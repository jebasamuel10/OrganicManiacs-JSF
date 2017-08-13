package com.web.service;

import com.google.gson.Gson;
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
	public void addStock(Stock stock) {
		Gson gson = new Gson();
		String inputString = gson.toJson(stock);
		String result = ServiceUtil.callPostRESTservice("admin/addStock", inputString);
		System.out.println(result);

		return;

	}

}
