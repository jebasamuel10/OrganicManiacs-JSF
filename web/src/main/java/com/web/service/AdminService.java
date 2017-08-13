package com.web.service;

import com.web.model.Category;
import com.web.model.Product;
import com.web.model.SourceFrom;

public interface AdminService {
	public void saveProduct(Product pro);
	public void addCategory(Category category);
	public void saveFarmer(SourceFrom source);
}
