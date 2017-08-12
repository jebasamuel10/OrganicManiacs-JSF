package com.web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.web.model.CarouselItem;
import com.web.model.Category;
import com.web.model.ImageDetail;
import com.web.model.Product;

public class ProductServiceImpl implements ProductService {
	private ProductServiceImpl() {
	}

	private static ProductServiceImpl service;
	static {
		try {
			if (null == service) {
				service = new ProductServiceImpl();
			}
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static ProductServiceImpl getObject() {
		return service;
	}

	@Override
	public List<Category> getCategoryList() {
		List<Category> categoryList = new ArrayList<>();
		for(int i=0;i<10;i++){
			ImageDetail id= new ImageDetail();
			id.setImgLocation(""+i+".jpg");
			Category cat= new Category();
			cat.setCategoryName("Category Name"+i);
			
			cat.setImg(id);
			
			System.out.println("cat"+cat.getImg().getImgLocation());
			categoryList.add(cat);
		}
		return categoryList ;
	}

	@Override
	public List<Product> getProductList(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CarouselItem> getCarouselList() {
		List<CarouselItem> carouselList= new ArrayList<>();
		for(int i=0;i<6;i++){
			CarouselItem ci= new CarouselItem();
			ci.setCaption("Caption :"+i);
			ci.setHeader("Header :"+i);
			ci.setImageLocation(""+i+".jpg");
			carouselList.add(ci);
			System.out.println(ci.getImageLocation());
		}
		return carouselList;
	}

	@Override
	public List<Product> getBestSellers() {
		List<Product> bestSellingItems= new ArrayList<>();
		//get/AllProducts
		Gson gson = new Gson();
		String result = callRESTservice("get/AllProducts");
		bestSellingItems = gson.fromJson(result, new TypeToken<List<Product>>(){}.getType());
		return bestSellingItems;
	}
	private String callRESTservice(String serviceName) {
		try {
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			String restURL = "http://localhost:8089/" + serviceName;
			// StringEntity input = new StringEntity(inputString);
			System.out.println(restURL);
			HttpGet getRequest = new HttpGet(restURL);
//			HttpPost postRequest = new HttpPost(restURL);
//			postRequest.addHeader("content-type", "application/json");
//			postRequest.addHeader("Accept", "application/json");
			// postRequest.setEntity(input);
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
	

}
