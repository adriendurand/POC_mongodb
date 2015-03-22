package com.adrien.mongodbPOC.service;

import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adrien.mongodbPOC.bean.Books;
import com.adrien.mongodbPOC.dao.MongodbDAO;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;

public class MongoDBService {

	private static final String COL_BOOKS = "books";
	private final static Logger logger = LoggerFactory.getLogger(MongoDBService.class);
	private MongodbDAO mongodbDAO = new MongodbDAO();
	private MongoCollection<Document> colBooks = mongodbDAO.findCollection(COL_BOOKS);

	/**
	 * 
	 * @return
	 */
	public FindIterable<Document> findBooks() {
		FindIterable<Document> books = mongodbDAO.findDocuments(COL_BOOKS);

		for (Document book : books) {
			logger.debug(book.toString());
		}

		return books;
	}

	/**
	 * 
	 * @return
	 */
	public MongoIterable<Document> findAllCollections() {
		MongoIterable<Document> cols = mongodbDAO.getAllCollections();

		for (Document col : cols) {
			logger.debug(col.toString());
		}

		return cols;
	}

	/**
	 * 
	 * @param book
	 */
	public void saveBook(Books book) {
		Document doc = populateDBObject(book);
		mongodbDAO.insertDocument(colBooks, doc);
	}

	/**
	 * 
	 * @param books
	 */
	public void saveBooks(List<Books> books) {
		for (Books book : books) {
			this.saveBook(book);
		}
	}

	public Books findBook(int id) {
		FindIterable<Document> doc = mongodbDAO.findDocument(COL_BOOKS, new Document("_id", id));
		return null;
	}

	/**
	 * 
	 * @param book
	 */
	public void removeBook(Books book) {
		mongodbDAO.removeDocument(colBooks, new Document("_id", book.getId()));
	}

	/**
	 * 
	 * @param book
	 * @return
	 */
	private Document populateDBObject(Books book) {
		Document dBook = new Document();
		dBook.append("_id", book.getId());
		dBook.append("title", book.getTitle());
		dBook.append("author", book.getAuthor());
		dBook.append("nbPages", book.getNbPages());

		return dBook;
	}

}
