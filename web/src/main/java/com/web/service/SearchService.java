package com.web.service;

import java.util.List;

import com.web.model.CarouselItem;
import com.web.model.Category;
import com.web.model.Product;

public interface SearchService {
	public List<String> completeSearch(String str);
	public List<CarouselItem> getCarouselList();
	public List<Category> getCategoryList();
	public List<Product> getBestSellers();
	public List<Product> getProductList(String category);
	public List<Product> getSearchResult(String product);
}
