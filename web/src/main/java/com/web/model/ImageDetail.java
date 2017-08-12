package com.web.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

public class ImageDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private UploadedFile imgage;
	private String imgLocation;
	private String altText;
	
	public UploadedFile getImgage() {
		return imgage;
	}
	public void setImgage(UploadedFile imgage) {
		this.imgage = imgage;
	}
	public StreamedContent getImg() throws IOException {
	        FacesContext context = FacesContext.getCurrentInstance();

	        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	            return new DefaultStreamedContent();
	        }
	        else {
	            return new DefaultStreamedContent(new ByteArrayInputStream(getImgage().getContents()));
	        }
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
	@Override
	public String toString() {
		return "ImageDetail [id=" + id + ", imgage=" + imgage + ", imgLocation=" + imgLocation + ", altText=" + altText
				+ "]";
	}
	
}
