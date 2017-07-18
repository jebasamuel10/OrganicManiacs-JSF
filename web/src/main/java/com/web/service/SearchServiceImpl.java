package com.web.service;

import java.util.ArrayList;
import java.util.List;

import com.web.model.Product;

public class SearchServiceImpl implements SearchService {
	private SearchServiceImpl() {
	}

	private static SearchServiceImpl service;
	static {
		try {
			if (null == service) {
				service = new SearchServiceImpl();
			}
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static SearchServiceImpl getObject() {
		return service;
	}

	@Override
	public List<String> completeSearch(String str) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			result.add("String  " + i);
			System.out.println("String  " + i);
		}
		return result;
	}

	@Override
	public List<Product> getSearchResult(String product) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
