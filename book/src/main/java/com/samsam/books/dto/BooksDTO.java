package com.samsam.books.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooksDTO {
	private String bookImageURL;
	private String bookname;
	private String authors;
	private String publisher;
	private String publicationYear;
	private String callNum;
	private String className;
	private String isbn13;
}