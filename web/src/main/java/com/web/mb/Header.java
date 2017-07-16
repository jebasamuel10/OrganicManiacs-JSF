package com.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "header")
@ViewScoped
public class Header implements Serializable {
	private static final long serialVersionUID = 1L;
	private String searchString;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public List<String> completeSearch(String str) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			result.add(i + "String  " + i);
			System.out.println(i + "String  " + i);
		}
		return result;
	}
}
