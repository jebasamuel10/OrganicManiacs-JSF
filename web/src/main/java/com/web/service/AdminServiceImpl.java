package com.web.service;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.web.model.Category;
import com.web.model.Product;
import com.web.model.SourceFrom;
import com.web.model.Stock;

public class AdminServiceImpl implements AdminService {
	private AdminServiceImpl() {
	}

	private static AdminServiceImpl service;
	static {
		try {
			if (null == service) {
				service = new AdminServiceImpl();
			}
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static AdminServiceImpl getObject() {
		return service;
	}

	@Override
	public void saveProduct(Product pro) {
		Gson gson = new Gson();
		String inputString = gson.toJson(pro);
		String result = ServiceUtil.callPostRESTservice("admin/addProduct", inputString);
		System.out.println(result);
		return;
	}

	
	@Override
	public Product getProductDtls(String name) {
		Gson gson = new Gson();
		String inputString = gson.toJson(name);
		String result = ServiceUtil.callPostRESTservice("admin/getProduct", inputString);
		System.out.println(result);
		Product pro = gson.fromJson(result, Product.class);
		return pro;
	}

	@Override
	public void deleProduct(String name) {
		Gson gson = new Gson();
		String inputString = gson.toJson(name);
		String result = ServiceUtil.callPostRESTservice("admin/deleteProduct", inputString);
		System.out.println(result);
		
	}

	@Override
	public Category editCategoryDtl(String categoryName) {
		Gson gson = new Gson();
		String inputString = gson.toJson(categoryName);
		String result = ServiceUtil.callPostRESTservice("admin/getCategory", inputString);
		System.out.println(result);
		Category category = gson.fromJson(result, Category.class);
		return category;
	}

	@Override
	public void deleteCategory(String categoryName) {
		Gson gson = new Gson();
		String inputString = gson.toJson(categoryName);
		String result = ServiceUtil.callPostRESTservice("admin/deleteCategory", inputString);
		System.out.println(result);
		
	}

	@Override
	public void addCategory(Category category) {
		Gson gson = new Gson();
		String inputString = gson.toJson(category);
		String result = ServiceUtil.callPostRESTservice("admin/addCategory", inputString);
		System.out.println(result);
		return;

	}

	@Override
	public void saveFarmer(SourceFrom source) {
		Gson gson = new Gson();
		String inputString = gson.toJson(source);
		String result = ServiceUtil.callPostRESTservice("admin/addSrcFrom", inputString);
		System.out.println(result);
		return;

	}

	@Override
	public SourceFrom editFarmer(String name) {
		Gson gson = new Gson();
		String inputString = gson.toJson(name);
		String result = ServiceUtil.callPostRESTservice("admin/getSourceFrom", inputString);
		System.out.println(result);
		SourceFrom sf = gson.fromJson(result, SourceFrom.class);
		return sf;
	}

	@Override
	public void delFarmer(String name) {
		Gson gson = new Gson();
		String inputString = gson.toJson(name);
		String result = ServiceUtil.callPostRESTservice("admin/deleteSourceFrom", inputString);
		System.out.println(result);
		
	}

	@Override
	public void addStock(Stock stock, int count) {
		Gson gson = new Gson();
		String inputString = gson.toJson(stock);
		///name/nos
		String url = "admin/addStock/"+count;
		String result = ServiceUtil.callPostRESTservice(url, inputString);
		System.out.println(result);

		return;

	}

}
