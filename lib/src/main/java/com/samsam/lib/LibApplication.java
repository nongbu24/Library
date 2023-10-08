package com.samsam.lib;

import com.samsam.lib.book.BookDTO;
import com.samsam.lib.db.DatabaseConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibApplication {
    public static void main(String[] args) {
        try {
            // 공공데이터 API에서 데이터를 가져오는 예제
            String apiUrl = "http://data4library.kr/api/itemSrch?authKey=558b4cc6e2673dcc61479b28615e9f5b9ec00805e4a41e40c1879cb038a806e4&libCode=141321&type=ALL&pageNo=1&pageSize=100&format=json";
            String jsonData = fetchDataFromApi(apiUrl); // API에서 데이터 가져오기
   
            // JSON 데이터를 BookDTO 객체로 변환
            BookDTO bookDTO = convertJsonToBookDTO(jsonData);

            // 데이터베이스에저장
            saveDataToDatabase(bookDTO);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // SQLException을 catch하여 오류 메시지 출력
            e.printStackTrace();
        }
    }

    private static String fetchDataFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        return response.toString();
    }

    private static BookDTO convertJsonToBookDTO(String jsonData) {
        // JSON 데이터를 파싱하여 BookDTO 객체로 변환하는 코드 작성
        // 예: JSON 파서 (Gson, Jackson 등)를 사용하여 파싱
        // BookDTO bookDTO = gson.fromJson(jsonData, BookDTO.class);

        // 임시적으로 더미 데이터를 생성하는 예제
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookname("Sample Book");
        bookDTO.setAuthors("John Doe");
        bookDTO.setPublisher("Sample Publisher");
        bookDTO.setPublicationYear("2023");
        bookDTO.setCallNum("12345");
        bookDTO.setClassName("Sample Class");
        bookDTO.setIsbn13("978-123456");

        return bookDTO;
    }

    private static void saveDataToDatabase(BookDTO bookDTO) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection()) { // MysqlConnector 클래스를 사용하여 연결
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

                int rowsAffected = stmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("데이터베이스에 데이터를 성공적으로 저장했습니다.");
                } else {
                    System.out.println("데이터베이스에 데이터를 저장하지 못했습니다.");
                }
            }
        } catch (SQLException e) {
            // SQLException을 catch하여 오류 메시지 출력
            e.printStackTrace();
        }
    }
}
