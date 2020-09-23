package com.qa.apacheclient.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.apacheclient.data.ReqresUsers;

public class ValidatePostRequest {

	@Test
	public void postRequestTest() throws ClientProtocolException, IOException {

		String endpointUrl = "https://reqres.in/api/users";
		RestClient restClient = new RestClient();
		ReqresUsers users = new ReqresUsers("morpheus", "leader");

		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writeValueAsString(users);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");

		CloseableHttpResponse response = restClient.post(endpointUrl, jsonBody, map);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);

		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject jsonResponse = new JSONObject(responseString);

		System.out.println(jsonResponse);
	}

}
