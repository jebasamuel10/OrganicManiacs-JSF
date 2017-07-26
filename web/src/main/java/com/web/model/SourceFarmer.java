package com.web.model;

import java.io.Serializable;
import java.util.List;

public class SourceFarmer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private ImageDetail img;
	private String name;
	private String district;
	private String phNo;
	private String address;
	private List<String> productList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ImageDetail getImg() {
		return img;
	}

	public void setImg(ImageDetail img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getProductList() {
		return productList;
	}

	public void setProductList(List<String> productList) {
		this.productList = productList;
	}
}
