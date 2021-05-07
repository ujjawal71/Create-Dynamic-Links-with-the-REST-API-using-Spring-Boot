package com.springboot.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ShareService {

	
	
	public String getsharelink()  throws JSONException, UnsupportedEncodingException, IOException
	{
		
				URL urllink = new URL ("https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=api_key");
				
				HttpURLConnection con = (HttpURLConnection)urllink.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setRequestProperty("Accept", "application/json");
				con.setDoOutput(true);
				
				String jsonInputString = "{\"longDynamicLink\": \"https://example.page.link/?link=https://www.example.com/&apn=com.example.android&ibi=com.example.ios\"}";
				
				
				try(OutputStream os = con.getOutputStream()) {
				    byte[] input = jsonInputString.getBytes("utf-8");
				    os.write(input, 0, input.length);			
				}
				
				
				try(BufferedReader br = new BufferedReader(
						  new InputStreamReader(con.getInputStream(), "utf-8"))) {
						    StringBuilder response = new StringBuilder();
						    String responseLine = null;
						    while ((responseLine = br.readLine()) != null) {
						        response.append(responseLine.trim());
						    }
						    System.out.println(response.toString());
						    JSONObject myResponse = new JSONObject(response.toString());
						   String  urlsharelink= myResponse.getString("shortLink");
						   
						  
						 
						   
						   return urlsharelink;
						  
						}
				
				
	}
	
}
