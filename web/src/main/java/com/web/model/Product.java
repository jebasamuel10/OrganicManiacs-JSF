package com.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public enum measuringUnit {
		Gram, KG, lt, Nos
	};

	public enum scaleLst {
		ONE(1), TWO(2), FIVE(5), TEN(10), FIFTY(50), HUNDRED(100), TWO_HUNDRED(200), TWO_FIFTY(250), FIVE_HUNDRED(
				500), SEVEN_FIFTY(750);
		private int value;

		private scaleLst(int value) {
			this.value = value;
		}
	};

	private List<ImageDetail> imgList;
	private ImageDetail defaultImage;
	private String productName;
	private String shortDesc;
	private String categoryName;
	private double mrp;
	private double ourPrice;
	private int stock;
	private String measuringUnit;
	private int scale;
	private String longDesc;
	private List<SupportURL> benifits;
	private List<SupportURL> recipe;
	private Date packedDate;
	private Date receivedDate;
	private Date expireDate;
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
	public double getOurPrice() {
		return ourPrice;
	}
	public void setOurPrice(double ourPrice) {
		this.ourPrice = ourPrice;
	}
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
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getMeasuringUnit() {
		return measuringUnit;
	}
	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
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
