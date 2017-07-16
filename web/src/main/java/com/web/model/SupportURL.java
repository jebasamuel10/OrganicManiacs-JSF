package com.web.model;

import java.io.Serializable;

public class SupportURL implements Serializable {
	private static final long serialVersionUID = 1L;
	private String url;
	private String desc;
	private boolean video;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
