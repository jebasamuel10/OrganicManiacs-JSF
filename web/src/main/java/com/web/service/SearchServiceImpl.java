package com.web.service;

public class SearchServiceImpl implements SearchService {
	private SearchServiceImpl() {
	}

	private static SearchServiceImpl service;
	static {
		try {
			if (null == service) {
				service = new SearchServiceImpl();
			}
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static SearchServiceImpl getObject() {
		return service;
	}
}
