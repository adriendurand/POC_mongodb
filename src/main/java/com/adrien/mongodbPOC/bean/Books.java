package com.adrien.mongodbPOC.bean;

public class Books {

	private int _id;
	private String title;
	private String author;
	private int nbPages;

	public Books() {
	}

	public Books(int _id, String title, String author, int nbPages) {
		this._id = _id;
		this.title = title;
		this.author = author;
		this.nbPages = nbPages;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
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

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		return "Books [_id=" + _id + ", title=" + title + ", author=" + author + ", nbPages=" + nbPages + "]";
	}

}
