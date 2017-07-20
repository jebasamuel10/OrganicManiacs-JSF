package com.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.web.model.Category;
import com.web.model.Product;
import com.web.model.Stock;

@ManagedBean(name = "addStock")
@ViewScoped
public class AddStock implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> categoryList;
	private Category selectedCategory;
	private List<String> productList;
	private Product selectedProduct;
	private Stock proStock;
	
	public List<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	public Category getSelectedCategory() {
		return selectedCategory;
	}
	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
	public List<String> getProductList() {
		return productList;
	}
	public void setProductList(List<String> productList) {
		this.productList = productList;
	}
	public Product getSelectedProduct() {
		return selectedProduct;
	}
	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	public Stock getProStock() {
		return proStock;
	}
	public void setProStock(Stock proStock) {
		this.proStock = proStock;
	}
	@PostConstruct
	public void init(){
		categoryList = new ArrayList<>();
		productList = new ArrayList<>();
	}
	public void saveStockProduct(){
		//AdminServiceImpl.getObject().saveProduct(pro);
	}
}
