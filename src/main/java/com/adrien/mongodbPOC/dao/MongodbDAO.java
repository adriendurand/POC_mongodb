package com.adrien.mongodbPOC.dao;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongodbDAO {

	private static final String COL_BOOKS = "books";

	private final static Logger logger = LoggerFactory.getLogger(MongodbDAO.class);

	private final String DB_NAME = "mydb";
	private MongoDatabase db;
	private MongoClient mongoClient;

	public MongodbDAO() {
		this.getConnection();
	}

	public void getAllCollections() {
		MongoIterable<String> cols = db.listCollectionNames();
		logger.debug("Collections: {}", cols.toString());
	}

	public MongoCollection<Document> getCollection(String colName) {
		return db.getCollection(colName);
	}

	public FindIterable<Document> findAllBooks() {
		return this.getCollection(COL_BOOKS).find();
	}

	private void getConnection() {
		mongoClient = new MongoClient();
		logger.debug("Databases: {}", mongoClient.listDatabaseNames().toString());
		this.setDb(mongoClient.getDatabase(DB_NAME));
	}

	public void closeConnection() {
		mongoClient.close();
	}

	public MongoDatabase getDb() {
		return db;
	}

	public void setDb(MongoDatabase db) {
		this.db = db;
	}
}
