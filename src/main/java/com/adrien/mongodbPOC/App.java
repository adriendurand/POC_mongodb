package com.adrien.mongodbPOC;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adrien.mongodbPOC.dao.MongodbDAO;
import com.mongodb.client.FindIterable;

/**
 * Hello world!
 *
 */
public class App {

	private final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		logger.debug("Main");
		MongodbDAO mongodbDAO = new MongodbDAO();

		FindIterable<Document> books = mongodbDAO.findAllBooks();
		for (Document book : books) {
			logger.debug(book.toString());
			logger.debug(book.toJson());
		}
	}
}
