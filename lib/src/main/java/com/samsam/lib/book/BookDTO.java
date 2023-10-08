package com.samsam.lib.book;

public class BookDTO {
	private String bookImageURL;
	private String bookname;
	private String authors;
	private String publisher;
	private String publicationYear;
	private String callNum;
	private String className;
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
	
	public String getPublicationYear() {
		return publicationYear;
	}
	
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public String getCallNum() {
		return callNum;
	}
	
	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getIsbn13() {
		return isbn13;
	}
	
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

}