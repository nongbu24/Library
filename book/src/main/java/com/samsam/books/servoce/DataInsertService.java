package com.samsam.books.servoce;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsam.books.mapper.BooksMapper;

@Service
public class DataInsertService {
	private final BooksMapper booksMapper;
	
	public DataInsertService(BooksMapper booksMapper) {
		this.booksMapper = booksMapper;
	}
	
	@Transactional
    public void insertData(String bookImageURL, String bookname, String authors, String publisher,
                           String publicationYear, String callNum, String className, String isbn13) {

        int rowsAffected = booksMapper.insertBooksInfo(bookImageURL, bookname, authors, publisher,
                publicationYear, callNum, className, isbn13);

        if (rowsAffected > 0)
            System.out.println("데이터 삽입이 성공했습니다.");
        else
            throw new RuntimeException("데이터 삽입이 실패했습니다.");

    }
	
}