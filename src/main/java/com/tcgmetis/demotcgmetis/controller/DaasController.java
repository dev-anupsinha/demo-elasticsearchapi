package com.tcgmetis.demotcgmetis.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcgmetis.demotcgmetis.models.GenericQueryForDaas;
import com.tcgmetis.demotcgmetis.service.MongoDbService;
import com.tcgmetis.demotcgmetis.service.MySqlDbService;

@RestController
@RequestMapping("/daas")
public class DaasController {
	
	@Autowired
	MySqlDbService mySqlDbService;
	
	@Autowired
	MongoDbService mongoDbService;

	private static final Logger daasCntrllogger = LoggerFactory.getLogger(DaasController.class);

	@GetMapping("/empwithpet")
	public List<Map<String,Object>> getEmpdetailsWithPet(@Valid @RequestBody GenericQueryForDaas query) throws Exception {
		
		List<Map<String, Object>> getQueryResult = null;
		
		daasCntrllogger.info("query values :{}", query.toString());
		if (!StringUtils.isEmpty(query.getDatasource().toString())) {
			if (query.getDatasource().equalsIgnoreCase("mongo")) {
				daasCntrllogger.info("call mongo DB");
				getQueryResult=mongoDbService.fetchPetsData(query.getQuery());

			} else if (query.getDatasource().equalsIgnoreCase("mysql")) {
				daasCntrllogger.info("call MySql DB {}",query.getQuery().get("from"));				
				getQueryResult= mySqlDbService.getTableRecords(query.getQuery());

			}else {
				System.out.println("Entered datsource is not valid");
				throw new RuntimeException("Entered datsource is not valid");
			}

		} else {
			System.out.println("datasource value is required");
			throw new RuntimeException("datasource value is required");
			
		}

		return getQueryResult;
	}

}
