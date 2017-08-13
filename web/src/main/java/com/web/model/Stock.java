package com.web.model;

import java.io.Serializable;

public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ProductId;
	private Product pro;
	private String measuringUnit;
	
	private double mrp;
	private double ourPrice;
	private String packedDate;
	private String receivedDate;
	private String expireDate;
	private String scale;
	private int counter;
	
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getMeasuringUnit() {
		return measuringUnit;
	}
	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public double getOurPrice() {
		return ourPrice;
	}
	public void setOurPrice(double ourPrice) {
		this.ourPrice = ourPrice;
	}
	public String getPackedDate() {
		return packedDate;
	}
	public void setPackedDate(String packedDate) {
		this.packedDate = packedDate;
	}
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
}
