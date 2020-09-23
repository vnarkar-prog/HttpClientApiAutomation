package com.qa.apacheclient.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.apacheclient.utils.TestUtils;

public class validateGetRequest {

	@Test
	public void getRequestTest() throws ClientProtocolException, IOException {

		RestClient restClient = new RestClient();
		CloseableHttpResponse httpResponse = restClient.get("https://reqres.in/api/users?page=2");

		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is:" + statusCode);

		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		JSONObject jsonResponse = new JSONObject(responseString);

		String s = TestUtils.getValueByJPath(jsonResponse, "/data[1]/first_name");
		System.out.println(s);

		HashMap<String, String> map = new HashMap<String, String>();

		Header[] headers = httpResponse.getAllHeaders();

		for (Header header : headers) {
			map.put(header.getName(), header.getValue());
		}
		//System.out.println(map);

	}

}
