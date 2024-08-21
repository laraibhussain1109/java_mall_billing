package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "billNo")
	private Invoice invoice;
	@Id
	@ManyToOne
	@JoinColumn(name = "itemId")
	private Item item;
	private int qty;
	
	public final Invoice getInvoice() {
		return invoice;
	}
	public final void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public final Item getItem() {
		return item;
	}
	public final void setItem(Item item) {
		this.item = item;
	}
	public final int getQty() {
		return qty;
	}
	public final void setQty(int qty) {
		this.qty = qty;
	}
	
}
