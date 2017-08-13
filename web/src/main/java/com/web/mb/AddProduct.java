package com.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.web.model.Category;
import com.web.model.ImageDetail;
import com.web.model.Product;
import com.web.model.SupportURL;
import com.web.service.AdminServiceImpl;
import com.web.service.ProductServiceImpl;

@ManagedBean(name = "addProduct")
@ViewScoped
public class AddProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private Product pro;
	private SupportURL selectedURL;
	private SupportURL selectedBenifit;
	private List<Category> proCategory;
	private List<String> measuringUnitLst = Arrays.asList(new String("Gram/KG"), new String("ltr"), new String("Nos"));

	public List<String> getMeasuringUnitLst() {
		return measuringUnitLst;
	}

	public void setMeasuringUnitLst(List<String> measuringUnitLst) {
		this.measuringUnitLst = measuringUnitLst;
	}
	public SupportURL getSelectedURL() {
		return selectedURL;
	}

	public void setSelectedURL(SupportURL selectedURL) {
		this.selectedURL = selectedURL;
	}

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public List<Category> getProCategory() {
		return proCategory;
	}

	public void setProCategory(List<Category> proCategory) {
		this.proCategory = proCategory;
	}

	public SupportURL getSelectedBenifit() {
		return selectedBenifit;
	}

	public void setSelectedBenifit(SupportURL selectedBenifit) {
		this.selectedBenifit = selectedBenifit;
	}

	@PostConstruct
	public void init() {
		pro = new Product();
		proCategory = ProductServiceImpl.getObject().getCategoryList();

	}

	public void saveProduct() {
		System.out.println("Save...");
		System.out.println("Save start" + pro);
		if (null == pro.getDefaultImage() && null != pro.getImgList())
			pro.setDefaultImage(pro.getImgList().get(0));
		System.out.println("Save cntd..");
		AdminServiceImpl.getObject().saveProduct(pro);
		System.out.println("Save completed");
	}

	public void addRecipe(ActionEvent event) {
		System.out.println("add Recipe");
		System.out.println(pro.getRecipe());
		if (null == pro.getRecipe())
			pro.setRecipe(new ArrayList<>());
		System.out.println(pro.getRecipe().size());
		SupportURL url = new SupportURL();
		url.setVideo(false);
		url.setDesc("a");
		url.setUrl("a");
		url.setId("1");
		pro.getRecipe().add(url);
		System.out.println(pro.getRecipe().size());
	}

	public void addBenifits(ActionEvent event) {
		System.out.println("add addBenifits");
		if (null == pro.getBenifits())
			pro.setBenifits(new ArrayList<>());
		System.out.println("add addBenifits -1");
		SupportURL url = new SupportURL();
		url.setVideo(false);
		url.setDesc("a");
		url.setUrl("a");
		url.setId("1");
		System.out.println(pro.getBenifits().size());
		pro.getBenifits().add(url);
		System.out.println(pro.getBenifits().size());
	}

	public void delRecipe(ActionEvent event) {
		System.out.println(pro.getRecipe().size());
		pro.getRecipe().remove(selectedURL);
		selectedURL = null;
		System.out.println(pro.getRecipe().size());
	}

	public void delBenifits(ActionEvent event) {
		System.out.println(pro.getBenifits().size());
		System.out.println(selectedBenifit);
		pro.getBenifits().remove(selectedBenifit);
		selectedBenifit = null;
		System.out.println(pro.getBenifits().size());
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();
		String fileName = uploadedFile.getFileName();
		String contentType = uploadedFile.getContentType();
		byte[] contents = uploadedFile.getContents(); // Or getInputStream()
		ImageDetail id = new ImageDetail();
		id.setImgage(uploadedFile);
		id.setAltText(fileName);
		if (null == pro.getImgList())
			pro.setImgList(new ArrayList<>());
		pro.getImgList().add(id);
	}
}
