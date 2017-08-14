package com.web.service;

import java.util.List;

import com.web.model.CarouselItem;
import com.web.model.Category;
import com.web.model.Product;

public interface ProductService {
	public List<CarouselItem> getCarouselList();
	public List<Category> getCategoryList();
	public List<String> getCategoryName();
	public List<String> getProductName();
	public List<Product> getBestSellers();
	public List<Product> getProductList(String category);
	public List<String> getProductName(String categoryName) ;
}
