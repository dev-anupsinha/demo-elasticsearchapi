package com.tcgmetis.demotcgmetis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.tcgmetis.demotcgmetis.document.ProfileDocument;
import com.tcgmetis.demotcgmetis.service.ProfileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/profiles")
//@Slf4j
public class ProfileController {
	
	private static final Logger profileCntrllogger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
    private ProfileService service;

    @Autowired
    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test(){
    	profileCntrllogger.info("test logger in debug mode");

        return "Success";
    }

    @PostMapping("/")
    public ResponseEntity createProfile(@RequestBody ProfileDocument document) throws Exception {
    	profileCntrllogger.info("creating  profile {}", document.toString());
        return new ResponseEntity(service.createProfileDocument(document), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateProfile(@RequestBody ProfileDocument document) throws Exception {
    	profileCntrllogger.info("update profile for id    =>  {} - with  {}", document.getId(),document.toString());
        return new ResponseEntity(service.updateProfile(document),  HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ProfileDocument findById(@PathVariable String id) throws Exception {
    	profileCntrllogger.info("get profile details with id    =>  {}", id);
        return service.findById(id);
    }

    @GetMapping
    public List<ProfileDocument> findAll() throws Exception {
    	profileCntrllogger.info("Get all profile details");
        return service.findAll();
    }

    @GetMapping("/technology-search")
    public List<ProfileDocument> search(@RequestParam(value = "technology") String technology) throws Exception {
    	profileCntrllogger.info("Deleting profile with technology    =>  {}", technology);
        return service.searchByTechnology(technology);
    }

    @GetMapping("/name-search")
    public List<ProfileDocument> searchByName(@RequestParam(value = "name") String name) throws Exception {
    	profileCntrllogger.info("searching profile with name    =>  {}", name);
        return service.findProfileByName(name);
    }


    @DeleteMapping("/{id}")
    public String deleteProfileDocument(@PathVariable String id) throws Exception {
    	profileCntrllogger.info("Deleting profile with UniqueId    =>  {}", id);
        return service.deleteProfileDocument(id);

    }


}
