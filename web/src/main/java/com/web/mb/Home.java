package com.web.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.web.model.CarouselItem;
import com.web.model.Category;
import com.web.model.Product;
import com.web.service.ProductServiceImpl;


@ManagedBean(name = "home")
@ViewScoped
public class Home implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<CarouselItem> carouselList;
	private List<Product> bestSellingItems;
	private List<Category> categoryList;
	
	public List<Product> getBestSellingItems() {
		return bestSellingItems;
	}
	public void setBestSellingItems(List<Product> bestSellingItems) {
		this.bestSellingItems = bestSellingItems;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public List<CarouselItem> getCarouselList() {
		return carouselList;
	}
	public void setCarouselList(List<CarouselItem> carouselList) {
		this.carouselList = carouselList;
	}
	
	@PostConstruct
	public void init(){
		carouselList = ProductServiceImpl.getObject().getCarouselList();
		bestSellingItems = ProductServiceImpl.getObject().getBestSellers();
		categoryList = ProductServiceImpl.getObject().getCategoryList();
	}
}
