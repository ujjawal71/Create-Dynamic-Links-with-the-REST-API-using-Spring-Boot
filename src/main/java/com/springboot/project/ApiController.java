package com.springboot.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ShareService shareService; 

	
	
	@GetMapping("/Sharelink")
	public String getSharelink() throws RestClientException, UnsupportedEncodingException, JSONException, IOException
	{   

		
		 // String sharelink1= restTemplate.getForObject(shareService.sharelink(),String.class);
		//System.out.println(sharelink1);
		//return sharelink1;
		
		return shareService.getsharelink();
			
		
	}
}
