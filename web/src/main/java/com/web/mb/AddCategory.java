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
import com.web.model.SupportURL;
import com.web.service.AdminServiceImpl;

@ManagedBean(name = "addCategory")
@ViewScoped
public class AddCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	private Category category;
	private Product selectedProduct;

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@PostConstruct
	public void init() {
		category = new Category();
	}
	public void editCategoryDtl() {
		if(null!=category.getCategoryName()) {
			category = AdminServiceImpl.getObject().editCategoryDtl(category.getCategoryName());
		}
	}
	
	public void delCategory() {
		if(null!=category.getCategoryName()) {
			AdminServiceImpl.getObject().deleteCategory(category.getCategoryName());
		}
	}
	public void saveProduct() {
		AdminServiceImpl.getObject().addCategory(category);
	}
	public void delProduct() {
		category.getProductList().remove(selectedProduct);
	}
	public void addProduct(ActionEvent event) {
		System.out.println("add getProductList");
		if (null == category.getProductList())
			category.setProductList(new ArrayList<>());
		
		category.getProductList().add(new Product());
	}
	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();
		String fileName = uploadedFile.getFileName();
		String contentType = uploadedFile.getContentType();
		byte[] contents = uploadedFile.getContents(); // Or getInputStream()
		ImageDetail id = new ImageDetail();
		id.setImgage(uploadedFile);
		id.setAltText(fileName);
		category.setImg(id);
	}

	public void saveCategory() {
		AdminServiceImpl.getObject().addCategory(category);
	}
}
