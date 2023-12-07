package com.seowoo.java;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorerV4 {
	// .env 파일로 SERVICE_KEY 값 불러오기
    Dotenv dotenv = Dotenv.configure().load();
    String SERVICE_KEY = dotenv.get("SERVICE_KEY");
	private static final String SERVICE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"; 
	
	private URL buildUrl(String baseDate, int nx, int ny) {
        StringBuilder sb = new StringBuilder(SERVICE_URL)
        .append("?ServiceKey=" + SERVICE_KEY) 
        .append("&pageNo=1")
        .append("&numOfRows=10") 
        .append("&dataType=JSON") 
        .append("&base_date=" + baseDate) 
        .append("&base_time=0600") 
        .append("&nx=" + Integer.toString(nx))
        .append("&ny=" + Integer.toString(ny));
        
        URL url = null;
        try {
        	url = new URL(sb.toString());
        	System.out.println("URL: " + sb.toString());
        } catch (MalformedURLException e) {
        	System.out.println("MalformedURLException: " + e.getMessage());
        }
        return url;
	}
	
	public String httpGet(String baseDate, int nx, int ny) {
		URL url = buildUrl(baseDate, nx, ny);
	
		if (url == null) {
			return ""; //return nothing 
		}
		
		StringBuilder sb = new StringBuilder();
		HttpURLConnection conn= null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());

			try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}				
			} catch (IOException e) {
				System.out.println("IOException for BufferedReader: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		} finally {
			if (conn != null) {
				conn.disconnect();	
			}
		}
        return sb.toString();
	}
	
    public static void main(String[] args) {
    	final String baseDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 부산시 사하구 다대 1동
    	final int nx = 96; 
    	final int ny = 73;
    	
    	ApiExplorerV4 api = new ApiExplorerV4();
    	String response = api.httpGet(baseDate, nx, ny);
    	System.out.println(response);
    }
}