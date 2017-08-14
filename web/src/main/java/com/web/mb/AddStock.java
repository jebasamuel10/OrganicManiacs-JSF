package com.web.mb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.web.model.Category;
import com.web.model.Product;
import com.web.model.Stock;
import com.web.service.AdminServiceImpl;
import com.web.service.ProductServiceImpl;

@ManagedBean(name = "addStock")
@ViewScoped
public class AddStock implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> categoryList;
	private Category selectedCategory;
	private List<String> productList;
	private Product selectedProduct;
	private Stock proStock;
	private Date packedDate;
	private Date receivedDate;
	private Date expireDate;
	private int counter;
	private List<String> scaleLst = Arrays.asList(new String("1"), new String("2"), new String("5"), new String("10"),
			new String("50"), new String("100"), new String("200"), new String("250"), new String("500"),
			new String("750"));
	private static SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd"); 
	public Date getPackedDate() {
		return packedDate;
	}
	public void setPackedDate(Date packedDate) {
		this.packedDate = packedDate;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public List<String> getScaleLst() {
		return scaleLst;
	}
	public void setScaleLst(List<String> scaleLst) {
		this.scaleLst = scaleLst;
	}
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
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	@PostConstruct
	public void init(){
		proStock = new Stock();
		//proStock.setPro(new Product());
		categoryList = ProductServiceImpl.getObject().getCategoryName();
		//productList = ProductServiceImpl.getObject().getProductName();
	}
	public void saveStockProduct(){
		Date d = getExpireDate();
		System.out.println(d);
		proStock.setExpireDate((sfd.format(d)));
		System.out.println(sfd.format(d));
		System.out.println(proStock.getExpireDate());
		d = getPackedDate();
		proStock.setPackedDate(sfd.format(d));
		d = getReceivedDate();
		proStock.setReceivedDate((sfd.format(d)));
		AdminServiceImpl.getObject().addStock(proStock,counter);
	}
	 public void onCategoryChange() {
	        if(proStock.getCategoryName() !=null && !proStock.getCategoryName().equals(""))
	        	productList = ProductServiceImpl.getObject().getProductName(proStock.getCategoryName());
	        else
	        	productList = new ArrayList<>();
	    }
}
