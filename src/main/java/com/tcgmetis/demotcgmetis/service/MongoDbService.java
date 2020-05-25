package com.tcgmetis.demotcgmetis.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.CursorType;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Service
public class MongoDbService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	MongoClient mongoClient;

	public List<Map<String, Object>> fetchPetsData(LinkedHashMap<String, Object> queryParamDetails) throws Exception {
		List<Map<String, Object>> storeDbValues = new ArrayList<>();
		MongoDatabase database = mongoClient.getDatabase("mydb");
		MongoCollection<Document> collection = database.getCollection(queryParamDetails.get("from").toString());
		// Document myDoc = collection.find().first();

		if (collection == null) {
			throw new RuntimeException("No Collection found with name of " + queryParamDetails.get("from").toString());
		}
		// db.getCollection('pets').find({_id:ObjectId("5ec536a215225825c9acb47b")})
		// db.getCollection('pets').find({name:"Liam"})
		BasicDBObject queryM = new BasicDBObject();
		queryM.append("species", "cat1");
		// new BasicDBObject("$gt", 30000));		
		
		for (Document cur : collection.find(queryM)) {
			System.out.println(cur.toJson());
			// cur.remove("_id");
			// list.add(JSONHelper.toJSON(cur.next().toMap()));
			Map<String, Object> map = new LinkedHashMap<>(cur);
			storeDbValues.add(map);

		}
		return storeDbValues;
	}
}
