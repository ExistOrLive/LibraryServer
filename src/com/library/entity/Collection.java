package com.library.entity;

import java.util.Date;

public class Collection {

	private int id;
	private Book bookId;
	private Reader readerId;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBookId() {
		return bookId;
	}
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	public Reader getReaderId() {
		return readerId;
	}
	public void setReaderId(Reader reader) {
		this.readerId= reader;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
