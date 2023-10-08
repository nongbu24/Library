package com.samsam.books.api.controller;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;

@Controller
public class ApiController {
	public static final String serviceKey = "558b4cc6e2673dcc61479b28615e9f5b9ec00805e4a41e40c1879cb038a806e4";
	
	public String BooksSave(String libCode, int pageSize) throws IOException{
		String url = "http://data4library.kr/api/itemSrch";
		
		url += "authKey=" + serviceKey;
		url += "&libCode=" + libCode;
		url += "&type=ALL";
		url += "&pageNo=1&pageSize=" + pageSize;
		url += "&format=json";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseText = "";
		String line;
		
		while ((line = br.readLine()) != null) {
			responseText += line;
		}
		
		br.close();
		urlConnection.disconnect();
		
		return responseText;
	}
	
}