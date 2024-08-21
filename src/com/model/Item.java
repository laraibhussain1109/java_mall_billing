package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Item {
	@Id
	private String itemId;
	private String itemDescription;
	private String unit;
	private int price;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shopId")
	private Shop shop;
	@OneToMany(mappedBy = "item")
	private Set<Transaction> trxs=new HashSet<Transaction>();
	
	public final String getItemId() {
		return itemId;
	}
	public final void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public final String getItemDescription() {
		return itemDescription;
	}
	public final void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public final String getUnit() {
		return unit;
	}
	public final void setUnit(String unit) {
		this.unit = unit;
	}
	public final int getPrice() {
		return price;
	}
	public final void setPrice(int price) {
		this.price = price;
	}
	public final Shop getShop() {
		return shop;
	}
	public final void setShop(Shop shop) {
		this.shop = shop;
	}
	public final Set<Transaction> getTrxs() {
		return trxs;
	}
	public final void setTrxs(Set<Transaction> trxs) {
		this.trxs = trxs;
	}
}
