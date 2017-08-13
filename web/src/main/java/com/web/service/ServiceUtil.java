package com.web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ServiceUtil {
	public static String callGetRESTservice(String serviceName) {
		try {
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			String restURL = "http://localhost:8089/" + serviceName;
			System.out.println(restURL);
			HttpGet getRequest = new HttpGet(restURL);
			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			StringBuilder result = new StringBuilder();
			while ((output = br.readLine()) != null) {
				result.append(output);
			}
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String callPostRESTservice(String serviceName, String inputString) {
		try {
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			String restURL = "http://localhost:8089/" + serviceName;
			StringEntity input = new StringEntity(inputString);
			System.out.println(restURL);
			System.out.println(inputString);
			HttpPost postRequest = new HttpPost(restURL);
			postRequest.addHeader("content-type", "application/json");
			postRequest.addHeader("Accept", "application/json");
			postRequest.setEntity(input);
			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			StringBuilder result = new StringBuilder();
			while ((output = br.readLine()) != null) {
				result.append(output);
			}
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
