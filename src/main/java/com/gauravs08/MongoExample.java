package com.gauravs08;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoExample {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        DB database = mongoClient.getDB("myMongoDb");

        // print existing databases
        mongoClient.getDatabaseNames().forEach(System.out::println);

        database.createCollection("customers", null);

        // print all collections in customers database
        database.getCollectionNames().forEach(System.out::println);

        // create data
        DBCollection collection = database.getCollection("customers");
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Sourabh2");
        document.put("company", "Web Developer");
        collection.insert(document);

        // create data
        BasicDBObject document2 = new BasicDBObject();
        
        document2.put("name", "Gaurav2");
        document2.put("company", "JavaDeveloper");
        collection.insert(document2);
        
        // update data
        BasicDBObject query = new BasicDBObject();
        query.put("name", "Gaurav");
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "gauravs08");
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        collection.update(query, updateObject);

        // read data
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "gauravs08");
        DBCursor cursor = collection.find(searchQuery);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

        // delete data
		/*
		 * BasicDBObject deleteQuery = new BasicDBObject(); deleteQuery.put("name",
		 * "gauravs08"); collection.remove(deleteQuery);
		 */
    }
}
