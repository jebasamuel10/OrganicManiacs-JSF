package com.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.web.model.CarouselItem;
import com.web.model.Category;
import com.web.model.ImageDetail;
import com.web.model.Product;


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
		carouselList = new ArrayList<>();
		for(int i=0;i<6;i++){
			CarouselItem ci= new CarouselItem();
			ci.setCaption("Caption :"+i);
			ci.setHeader("Header :"+i);
			ci.setImageLocation(""+i+".jpg");
			carouselList.add(ci);
			System.out.println(ci.getImageLocation());
		}
		bestSellingItems = new ArrayList<>();
		for(int i=0;i<10;i++){
			Product pr= new Product();
			pr.setProductName("Product Name"+i);
			ImageDetail id= new ImageDetail();
			id.setImgLocation(""+i+".jpg");
			pr.setDefaultImage(id);
			pr.setShortDesc("Short Description"+i);
			pr.setMrp(100);
			//pr.setMeasuringUnit(KG);
			//pr.setScale(1);
			bestSellingItems.add(pr);
			System.out.println(pr.getDefaultImage().getImgLocation());
		}
		categoryList = new ArrayList<>();
		for(int i=0;i<10;i++){
			ImageDetail id= new ImageDetail();
			id.setImgLocation(""+i+".jpg");
			Category cat= new Category();
			cat.setCategoryName("Category Name"+i);
			
			cat.setImg(id);
			
			System.out.println("cat"+cat.getImg().getImgLocation());
			categoryList.add(cat);
		}
	}
}
