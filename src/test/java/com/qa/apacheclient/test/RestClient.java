package com.qa.apacheclient.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

	public CloseableHttpResponse httpResponse;

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpResponse = httpClient.execute(httpGet);

		return httpResponse;

	}

	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);

		for (Map.Entry<String, String> headers : headerMap.entrySet()) {
			httpGet.addHeader(headers.getKey(), headers.getValue());
		}

		httpResponse = httpClient.execute(httpGet);
		return httpResponse;

	}

	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		for (Map.Entry<String, String> headers : headerMap.entrySet()) {
			httpPost.addHeader(headers.getKey(), headers.getValue());
		}

		httpResponse = httpClient.execute(httpPost);
		return httpResponse;

	}

}
