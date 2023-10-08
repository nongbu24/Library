package com.samsam.lib.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.samsam.lib.book.BookDTO;

public class DatabaseConnector {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/BookScentLibrary";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "1234";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
	
	public static void saveBookQualityData(BookDTO bookDTO) {
		try (Connection conn = getConnection()) {
			String sql = "INSERT INTO lib (bookImageURL, bookname, authors, publisher, publicationYear, callNum, className, isbn13)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, bookDTO.getBookImageURL());
				stmt.setString(2, bookDTO.getBookname());
				stmt.setString(3, bookDTO.getAuthors());
				stmt.setString(4, bookDTO.getPublisher());
				stmt.setString(5, bookDTO.getPublicationYear());
				stmt.setString(6, bookDTO.getCallNum());
				stmt.setString(7, bookDTO.getClassName());
				stmt.setString(8, bookDTO.getIsbn13());
				
				stmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}