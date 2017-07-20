package com.web.model;

import java.io.Serializable;

public class CarouselItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private String imageLocation;
	private String caption;
	private String header;
	private ImageDetail imageDetail;
	
	public ImageDetail getImageDetail() {
		return imageDetail;
	}
	public void setImageDetail(ImageDetail imageDetail) {
		this.imageDetail = imageDetail;
	}
	public String getImageLocation() {
		return imageLocation;
	}
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}

}
