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
		// http://localhost:8089/get/AllCategories
		Gson gson = new Gson();
		String result = ServiceUtil.callGetRESTservice("get/AllCategories");
		categoryList = gson.fromJson(result, new TypeToken<List<Category>>() {
		}.getType());
		return categoryList;
	}

	@Override
	public List<Product> getProductList(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarouselItem> getCarouselList() {
		List<CarouselItem> carouselList = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			CarouselItem ci = new CarouselItem();
			ci.setCaption("Caption :" + i);
			ci.setHeader("Header :" + i);
			ci.setImageLocation("" + i + ".jpg");
			carouselList.add(ci);
			System.out.println(ci.getImageLocation());
		}
		return carouselList;
	}

	@Override
	public List<Product> getBestSellers() {
		List<Product> bestSellingItems = new ArrayList<>();
		// get/AllProducts
		Gson gson = new Gson();
		String result = ServiceUtil.callGetRESTservice("get/AllProducts");
		bestSellingItems = gson.fromJson(result, new TypeToken<List<Product>>() {
		}.getType());
		return bestSellingItems;
	}

	@Override
	public List<String> getCategoryName() {
		List<String> categoryNames = new ArrayList<>();
		// get/AllProducts
		Gson gson = new Gson();
		String result = ServiceUtil.callGetRESTservice("get/AllCategoryNames");
		categoryNames = gson.fromJson(result, new TypeToken<List<String>>() {
		}.getType());
		return categoryNames;
	}

	@Override
	public List<String> getProductName() {
		List<String> productNames = new ArrayList<>();
		// get/AllProducts
		Gson gson = new Gson();
		String result = ServiceUtil.callGetRESTservice("get/AllProductName");
		productNames = gson.fromJson(result, new TypeToken<List<String>>() {
		}.getType());
		return productNames;
	}
	@Override
	public List<String> getProductName(String categoryName) {
		List<String> productNames = new ArrayList<>();
		// get/AllProducts
		Gson gson = new Gson();
		String inputString = gson.toJson(categoryName);
		String result = ServiceUtil.callPostRESTservice("get/AllProductName", inputString);
		productNames = gson.fromJson(result, new TypeToken<List<String>>() {
		}.getType());
		return productNames;
	}
}
