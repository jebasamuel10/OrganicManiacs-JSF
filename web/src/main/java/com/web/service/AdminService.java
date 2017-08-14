package com.web.service;

import com.web.model.Category;
import com.web.model.Product;
import com.web.model.SourceFrom;
import com.web.model.Stock;

public interface AdminService {
	public void saveProduct(Product pro);
	public void addCategory(Category category);
	public void saveFarmer(SourceFrom source);
	public void addStock(Stock stock, int count);
	public Category editCategoryDtl(String categoryName);
	public void deleteCategory(String categoryName);
	public SourceFrom editFarmer(String name);
	public void delFarmer(String name);
	public Product getProductDtls(String name);
	public void deleProduct(String name);
}
