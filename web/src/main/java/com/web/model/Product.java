package com.web.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private List<ImageDetail> imgList;
	private ImageDetail defaultImage;
	private String productName;
	private String shortDesc;
	private String categoryName;
	private String measuringUnit;

	private String longDesc;
	private List<SupportURL> benifits;
	private List<SupportURL> recipe;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ImageDetail> getImgList() {
		return imgList;
	}

	public void setImgList(List<ImageDetail> imgList) {
		this.imgList = imgList;
	}

	public ImageDetail getDefaultImage() {
		return defaultImage;
	}

	public void setDefaultImage(ImageDetail defaultImage) {
		this.defaultImage = defaultImage;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getMeasuringUnit() {
		return measuringUnit;
	}

	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public List<SupportURL> getBenifits() {
		return benifits;
	}

	public void setBenifits(List<SupportURL> benifits) {
		this.benifits = benifits;
	}

	public List<SupportURL> getRecipe() {
		return recipe;
	}

	public void setRecipe(List<SupportURL> recipe) {
		this.recipe = recipe;
	}

}
