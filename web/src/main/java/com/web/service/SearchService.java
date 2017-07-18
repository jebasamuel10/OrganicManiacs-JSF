package com.web.service;

import java.util.List;

import com.web.model.Product;

public interface SearchService {
	public List<String> completeSearch(String str);
	public List<Product> getSearchResult(String product);
}
