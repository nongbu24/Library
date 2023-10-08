package com.samsam.books.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BooksMapper {
	@Insert("INSERT INTO BOOKS VALUES(#{bookImageURL}, #{bookname}, #{authors}, #{publisher}, #{publicationYear}, #{callNum}, #{className}, #{isbn13})")
	int insertBooksInfo(@Param("bookImageURL") String bookImageURL, @Param("bookname") String bookname, @Param("authors") String authors, @Param("publisher") String publisher, @Param("publicationYear") String publicationYear, @Param("callNum") String callNum, @Param("className") String className, @Param("isbn13") String isbn13);
}