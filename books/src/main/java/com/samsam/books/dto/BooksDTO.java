package com.samsam.books.dto;

public class BooksDTO {
	private String bookImageURL;
	private String bookname;
	private String authors;
	private String publisher;
	private String publication_year;
	private String callNumber;
	private String class_no;
	private String isbn13;
	
	public String getBookImageURL() {
		return bookImageURL;
	}
	
	public void setBookImageURL(String bookImageURL) {
		this.bookImageURL = bookImageURL;
	}

	public String getBookname() {
		return bookname;
	}
	
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public String getAuthors() {
		return authors;
	}
	
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getPublication_year() {
		return publication_year;
	}
	
	public void setPublication_year(String publication_year) {
		this.publication_year = publication_year;
	}
	
	public String getCallNumber() {
		return callNumber;
	}
	
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	
	public String getClass_no() {
		return class_no;
	}
	
	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}
	
	public String getIsbn13() {
		return isbn13;
	}
	
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
}