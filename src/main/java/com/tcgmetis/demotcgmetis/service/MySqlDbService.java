package com.tcgmetis.demotcgmetis.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MySqlDbService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger mysqlServiceLogger = LoggerFactory.getLogger(MySqlDbService.class);
	
	public List<Map<String, Object>> getTableRecords(LinkedHashMap<String, Object> queryParamDetails) throws Exception {
		
		mysqlServiceLogger.info("called mysql getTableRecords with {} query details",queryParamDetails.toString());
		
		String queryStr = "SELECT * FROM "+queryParamDetails.get("from"); // can use sort,limit and etc
		
		if(queryParamDetails.containsKey("id")) {
			queryStr+=" where emp_id="+queryParamDetails.get("id").toString();
		}
		
		System.out.println("final query "+queryStr);
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(queryStr);
		
        return rows;

 }

}
