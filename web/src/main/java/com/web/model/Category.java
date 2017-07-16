package com.web.model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private String categoryName;
	private List<Product> productList;
	private ImageDetail img;
	private boolean searchResult;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public ImageDetail getImg() {
		return img;
	}
	public void setImg(ImageDetail img) {
		this.img = img;
	}
	public boolean isSearchResult() {
		return searchResult;
	}
	public void setSearchResult(boolean searchResult) {
		this.searchResult = searchResult;
	}
	
}
