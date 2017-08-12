package com.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.web.model.Category;
import com.web.model.ImageDetail;
import com.web.model.Product;
import com.web.model.SupportURL;
import com.web.service.AdminServiceImpl;

@ManagedBean(name = "addProduct")
@SessionScoped
public class AddProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private Product pro;
	private SupportURL selectedURL;
	private List<Category> proCategory;

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

	@PostConstruct
	public void init() {
		pro = new Product();
		proCategory = new ArrayList<>();
	}

	public void saveProduct() {
		System.out.println("Save...");
		System.out.println("Save start"+pro);
		if (null == pro.getDefaultImage())
			pro.setDefaultImage(pro.getImgList().get(0));
		System.out.println("Save cntd..");
		AdminServiceImpl.getObject().saveProduct(pro);
		System.out.println("Save completed");
	}

	public void addRecipe() {
		System.out.println("add Recipe");
		System.out.println(pro.getRecipe());
		if (null == pro.getRecipe())
			pro.setRecipe(new ArrayList<>());
		System.out.println(pro.getRecipe().size());
		SupportURL url = new SupportURL();
		url.setVideo(false);
		url.setDesc("a");
		url.setUrl("a");
		pro.getRecipe().add(url);
		System.out.println(pro.getRecipe().size());
	}

	public void addBenifits() {
		if (null == pro.getBenifits())
			pro.setRecipe(new ArrayList<>());
		pro.getBenifits().add(new SupportURL());
	}

	public void delRecipe() {
		System.out.println(pro.getRecipe().size());
		pro.getRecipe().remove(selectedURL);
		selectedURL = null;
		System.out.println(pro.getRecipe().size());
	}

	public void delBenifits() {
		pro.getBenifits().remove(selectedURL);
		selectedURL = null;
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
