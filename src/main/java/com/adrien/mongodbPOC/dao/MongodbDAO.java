package com.adrien.mongodbPOC.dao;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongodbDAO {

	private final static Logger logger = LoggerFactory.getLogger(MongodbDAO.class);

	private final String DB_NAME = "mydb";
	private MongoDatabase db;
	private MongoClient mongoClient;

	/**
	 * 
	 */
	public MongodbDAO() {
		this.getConnection();
	}

	/**
	 * 
	 * @return
	 */
	public ListCollectionsIterable<Document> getAllCollections() {
		return db.listCollections();
	}

	/**
	 * 
	 * @param colName
	 * @return
	 */
	public MongoCollection<Document> findCollection(String colName) {
		return db.getCollection(colName);
	}

	/**
	 * 
	 * @param colName
	 * @return
	 */
	public FindIterable<Document> findDocuments(String colName) {
		return this.findCollection(colName).find();
	}

	/**
	 * 
	 * @param colName
	 * @return
	 */
	public FindIterable<Document> findDocument(String colName, Document doc) {
		return this.findCollection(colName).find(doc);
	}

	/**
	 * 
	 * @param col
	 */
	public void removeDocuments(MongoCollection<Document> col) {
		col.drop();
	}

	/**
	 * @param col
	 */
	public void removeDocument(MongoCollection<Document> col, Document doc) {
		col.findOneAndDelete(doc);
	}

	/**
	 * 
	 */
	private void getConnection() {
		mongoClient = new MongoClient();
		logger.debug("Databases: {}", mongoClient.listDatabaseNames().toString());
		this.setDb(mongoClient.getDatabase(DB_NAME));
	}

	/**
	 * 
	 */
	public void closeConnection() {
		mongoClient.close();
	}

	/**
	 * 
	 * @return
	 */
	public MongoDatabase getDb() {
		return db;
	}

	/**
	 * 
	 * @param db
	 */
	public void setDb(MongoDatabase db) {
		this.db = db;
	}

	/**
	 * 
	 * @param collection
	 * @param document
	 */
	public void insertDocument(MongoCollection<Document> collection, Document document) {
		collection.insertOne(document);
	}

}
