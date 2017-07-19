package com.web.service;

import com.web.model.Product;

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
		System.out.println("completed");
		
	}

}
