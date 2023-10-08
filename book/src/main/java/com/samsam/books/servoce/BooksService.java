package com.samsam.books.servoce;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BooksService {
	@Value("${public.api.url}")
	private String apiUrl;
	
	private final RestTemplate restTemplate;
	
	public BooksService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String fetchDataFromApi() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
		
		if (responseEntity.getStatusCode().is2xxSuccessful())
			return responseEntity.getBody();
		else
			throw new RuntimeException("API 호출이 실패했습니다.");
	}
	
}