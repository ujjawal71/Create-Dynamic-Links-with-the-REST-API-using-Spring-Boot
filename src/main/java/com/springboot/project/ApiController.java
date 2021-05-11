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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ApiController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ShareService shareService; 

	
	
	@RequestMapping(value = "/Sharelink/{id}", method = {   RequestMethod.GET })
	public ShareModel getSharelink( @PathVariable("id") int id) 
	{   

		return this.shareService.getLink(id);
			
		
	}
	
	
	
	@RequestMapping(value = "/Sharelink/", method = {  RequestMethod.GET })
	public ShareModel addSharelink() throws RestClientException, UnsupportedEncodingException, JSONException, IOException
	{   
		 String sharelink=shareService.getsharelink();
		  JSONObject jsonObject = new JSONObject("{\"longDynamicLink\":\"" + sharelink +"\"}");
		  ObjectMapper objectMapper = new ObjectMapper();
		  ShareModel shareModel1 = objectMapper.readValue(jsonObject.toString(), ShareModel.class); 
		  ShareModel link=this.shareService.addLink(shareModel1);
		
		 
		 // String sharelink1= restTemplate.getForObject(shareService.sharelink(),String.class);
		//System.out.println(sharelink1);
		//return sharelink1;
		
		return link;
			
		
	}
	
	
}
