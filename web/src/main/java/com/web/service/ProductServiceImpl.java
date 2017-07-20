package com.web.service;

import java.util.ArrayList;
import java.util.List;

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
		for(int i=0;i<10;i++){
			ImageDetail id= new ImageDetail();
			id.setImgLocation(""+i+".jpg");
			Category cat= new Category();
			cat.setCategoryName("Category Name"+i);
			
			cat.setImg(id);
			
			System.out.println("cat"+cat.getImg().getImgLocation());
			categoryList.add(cat);
		}
		return categoryList ;
	}

	@Override
	public List<Product> getProductList(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CarouselItem> getCarouselList() {
		List<CarouselItem> carouselList= new ArrayList<>();
		for(int i=0;i<6;i++){
			CarouselItem ci= new CarouselItem();
			ci.setCaption("Caption :"+i);
			ci.setHeader("Header :"+i);
			ci.setImageLocation(""+i+".jpg");
			carouselList.add(ci);
			System.out.println(ci.getImageLocation());
		}
		return carouselList;
	}

	@Override
	public List<Product> getBestSellers() {
		List<Product> bestSellingItems= new ArrayList<>();
		for(int i=0;i<10;i++){
			Product pr= new Product();
			pr.setProductName("Product Name"+i);
			ImageDetail id= new ImageDetail();
			id.setImgLocation(""+i+".jpg");
			pr.setDefaultImage(id);
			pr.setShortDesc("Short Description"+i);
			//pr.setMrp(100);
			//pr.setMeasuringUnit(KG);
			//pr.setScale(1);
			bestSellingItems.add(pr);
			System.out.println(pr.getDefaultImage().getImgLocation());
		}
		return bestSellingItems;
	}

}
