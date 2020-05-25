package com.tcgmetis.demotcgmetis.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcgmetis.demotcgmetis.models.Pets;
import com.tcgmetis.demotcgmetis.repository.PetsRepository;

@RestController
@RequestMapping("/mongo")
public class MongoDbController {
	
  @Autowired
  private PetsRepository petRepository;
  
  @Autowired
  MongoTemplate mongoTemplate;
  
 
  
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public List<Pets>
	 * getAllPets() { return repository.findAll(); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET) public Pets
	 * getPetById(@PathVariable("id") ObjectId id) { return
	 * repository.findBy_id(id); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.PUT) public void
	 * modifyPetById(@PathVariable("id") ObjectId id, @RequestBody Pets pets) {
	 * pets.set_id(id); repository.save(pets); }
	 */
  
  @PostMapping("/pets")
  public Pets createPet(@Valid @RequestBody Pets pets) {
    pets.set_id(ObjectId.get());
    petRepository.save(pets);
    return pets;
  }
  
	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) public void
	 * deletePet(@PathVariable ObjectId id) {
	 * repository.delete(repository.findBy_id(id)); }
	 */
  
 
}
