package com.tcgmetis.demotcgmetis.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.tcgmetis.demotcgmetis.models.Pets;

@Component
public class PetsWriterConverter implements Converter<Pets, DBObject> {

    @Override
    public DBObject convert(final Pets pets) {
        final DBObject dbObject = new BasicDBObject();
        dbObject.put("name", pets.getName());
        dbObject.put("species", pets.getSpecies());
        dbObject.put("breed", pets.getBreed());
		/*
		 * if (pets.getEmailAddress() != null) { final DBObject emailDbObject = new
		 * BasicDBObject(); emailDbObject.put("value",
		 * user.getEmailAddress().getValue()); dbObject.put("email", emailDbObject); }
		 */
        dbObject.removeField("_class");
        return dbObject;
    }

}
