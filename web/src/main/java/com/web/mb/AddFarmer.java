package com.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.web.model.Category;
import com.web.model.ImageDetail;
import com.web.model.Product;
import com.web.model.SourceFrom;
import com.web.model.SupportURL;
import com.web.service.AdminServiceImpl;

@ManagedBean(name = "addFarmer")
@ViewScoped
public class AddFarmer implements Serializable {
	private static final long serialVersionUID = 1L;
	private SourceFrom farmer;
	private String selectedProduct;

	public String getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(String selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public SourceFrom getFarmer() {
		return farmer;
	}

	public void setFarmer(SourceFrom farmer) {
		this.farmer = farmer;
	}

	@PostConstruct
	public void init() {
		farmer = new SourceFrom();
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();
		String fileName = uploadedFile.getFileName();
		String contentType = uploadedFile.getContentType();
		byte[] contents = uploadedFile.getContents(); // Or getInputStream()
		ImageDetail id = new ImageDetail();
		id.setImgage(uploadedFile);
		id.setAltText(fileName);
		farmer.setImg(id);
	}

	public void delProduct() {
		farmer.getProductList().remove(selectedProduct);
	}
	public void addProduct(ActionEvent event) {
		System.out.println("add addProduct");
		if (null == farmer.getProductList())
			farmer.setProductList(new ArrayList<>());
		System.out.println(farmer.getProductList().size());
		farmer.getProductList().add("a");
		System.out.println(farmer.getProductList().size());
	}
	public void saveFarmer() {
		AdminServiceImpl.getObject().saveFarmer(farmer);
	}
}
