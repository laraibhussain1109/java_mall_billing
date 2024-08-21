package com.bean;

import java.util.Set;
import java.util.TreeSet;

public class ItemSetBean {
	private Set<String> items=new TreeSet<String>();

	public final Set<String> getItems() {
		return items;
	}

	public final void setItems(Set<String> items) {
		this.items = items;
	}

	
}
