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
public class ShareService {

	@Autowired
	private LinkRepository linkRepository;

	public String getsharelink() throws JSONException, UnsupportedEncodingException, IOException {

		URL urllink = new URL ("https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=api_key");

		HttpURLConnection con = (HttpURLConnection) urllink.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		String jsonInputString = "{\"longDynamicLink\": \"https://example.page.link/?link=https://www.example.com/&apn=com.example.android&ibi=com.example.ios\"}";

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

	// adding Link
	public ShareModel addLink(ShareModel link) {
		ShareModel result = linkRepository.save(link);
		return result;
	}

	
	public ShareModel getLink(int id) {
		ShareModel sharelink1 = null;
		try {
			sharelink1 = this.linkRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sharelink1;
	}

}
