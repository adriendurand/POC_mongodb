package com.adrien.mongodbPOC.bean;

public class Books {

	private String id;
	private String title;
	private String author;
	private String nbPages;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNbPages() {
		return nbPages;
	}

	public void setNbPages(String nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", nbPages=" + nbPages + "]";
	}

}
