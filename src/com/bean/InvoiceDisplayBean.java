package com.bean;

import java.util.HashSet;
import java.util.Set;

import com.model.Item;

public class InvoiceDisplayBean {
	private Set<Item> items=new HashSet<Item>();
	private int total=0;
	private int slno;
	
	public final int getSlno() {
		return ++slno;
	}
	public final void setSlno(int slno) {
		this.slno = slno;
	}
	public final Set<Item> getItems() {
		return items;
	}
	public final void setItems(Set<Item> items) {
		this.items = items;
	}
	public final int getTotal() {
		for(Item item:items) {
			total+=item.getPrice();
		}
		return total;
	}
	public final void setTotal(int total) {
		this.total = total;
	}

}
