package com.adrien.mongodbPOC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adrien.mongodbPOC.bean.Books;
import com.adrien.mongodbPOC.service.MongoDBService;

/**
 *
 */
public class App {

	private final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		logger.debug("Main");
		MongoDBService mongodbService = new MongoDBService();
		List<Books> books = createBooks();
		mongodbService.findBooks();
		mongodbService.saveBooks(books);
		mongodbService.findBooks();

		mongodbService.findBook(4);
		mongodbService.removeBook(books.get(4));
	}

	private static List<Books> createBooks() {
		List<Books> books = new ArrayList<Books>();
		for (int i = 0; i < 10; i++) {
			books.add(new Books(i, "Title " + i, "Author " + i, new Random().nextInt(500 - 100) + 100));
		}
		return books;
	}
}
