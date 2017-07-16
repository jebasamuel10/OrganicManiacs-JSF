package com.web.model;

import java.io.Serializable;

import org.primefaces.model.StreamedContent;

public class ImageDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private String imgLocation;
	private String altText;
	public StreamedContent getImg(){
		return null;
	}
	public String getImgLocation() {
		return imgLocation;
	}
	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}
	public String getAltText() {
		return altText;
	}
	public void setAltText(String altText) {
		this.altText = altText;
	}
	
}
