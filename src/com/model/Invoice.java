package com.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Invoice {
	@Id
	private String billNo;
	private Date billDate;
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	private int discount;
	private int gst;
	@OneToMany(mappedBy = "invoice")
	private Set<Transaction> trxs=new HashSet<Transaction>();
	
	public final String getBillNo() {
		return billNo;
	}
	public final void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public final Date getBillDate() {
		return billDate;
	}
	public final void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public final Customer getCustomer() {
		return customer;
	}
	public final void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public final int getDiscount() {
		return discount;
	}
	public final void setDiscount(int discount) {
		this.discount = discount;
	}
	public final int getGst() {
		return gst;
	}
	public final void setGst(int gst) {
		this.gst = gst;
	}
	public final Set<Transaction> getTrxs() {
		return trxs;
	}
	public final void setTrxs(Set<Transaction> trxs) {
		this.trxs = trxs;
	}
}
