package com.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shop {
	@Id
	private String shopId;
	private String shopName;
	
	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
	private Set<Item> items=new TreeSet<Item>();
	
	public final String getShopId() {
		return shopId;
	}
	public final void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public final String getShopName() {
		return shopName;
	}
	public final void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public final Set<Item> getItems() {
		return items;
	}
	public final void setItems(Set<Item> items) {
		this.items = items;
	}
	
}
