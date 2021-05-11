package com.springboot.project;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class UsersService {

	@Autowired
	private UsersRepository linkRepository;

	public String getsharelink() throws JSONException, UnsupportedEncodingException, IOException {
		
		//Need To change link
        String api_key="Your API";
        String dynamiclink="https://example.page.link";
        String Applink="https://www.example.com/&apn=com.example.android&ibi=com.example.ios";
        //
        
		URL urllink = new URL(
				"https://firebasedynamiclinks.googleapis.com/v1/shortLinks/?key="+api_key+" ");
		HttpURLConnection con = (HttpURLConnection) urllink.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		String jsonInputString = "{\"longDynamicLink\": \""+dynamiclink+"?link="+Applink+ "\"}";
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
			JSONObject myResponse = new JSONObject(response.toString());
			String urlsharelink = myResponse.getString("shortLink");
			return urlsharelink;

		}

	}

	
	
	public UsersModel addUserdData(UsersModel usersModel) {
		UsersModel result = linkRepository.save(usersModel);
		return result;
	}
	

	
	public UsersModel getUserdData(int id) {
		UsersModel sharelink1 = null;
		try {
			sharelink1 = this.linkRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sharelink1;
	}

	// adding Link
		public UsersModel addLink(UsersModel usersModel) {
			UsersModel result = linkRepository.save(usersModel);
			return result;
		}
		


}
