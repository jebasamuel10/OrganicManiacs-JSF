package com.web.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ProductId;
	private String measuringUnit;
	private List<String> scaleLst = Arrays.asList(new String("1"), new String("2"), new String("5"), new String("10"),
			new String("50"), new String("100"), new String("200"), new String("250"), new String("500"),
			new String("750"));
	private double mrp;
	private double ourPrice;
	private Date packedDate;
	private Date receivedDate;
	private Date expireDate;
	private String scale;
	
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
	public List<String> getScaleLst() {
		return scaleLst;
	}
	public void setScaleLst(List<String> scaleLst) {
		this.scaleLst = scaleLst;
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
}
