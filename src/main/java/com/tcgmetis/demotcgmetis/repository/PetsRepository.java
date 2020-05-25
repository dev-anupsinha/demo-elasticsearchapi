package com.tcgmetis.demotcgmetis.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tcgmetis.demotcgmetis.models.Pets;

@Repository
public interface PetsRepository extends MongoRepository<Pets, String> {
	  Pets findBy_id(ObjectId _id);

}
