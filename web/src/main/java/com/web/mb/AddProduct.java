package com.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.web.model.Category;
import com.web.model.Product;
import com.web.service.AdminServiceImpl;

@ManagedBean(name = "addProduct")
@ViewScoped
public class AddProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private Product pro;
	private List<Category> proCategory;
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
	public void init(){
		pro=new Product();
		proCategory = new ArrayList<>();
	}
	public void saveProduct(){
		AdminServiceImpl.getObject().saveProduct(pro);
		
	}
}
