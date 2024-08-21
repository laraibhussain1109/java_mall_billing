package com.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private String customerId;
	private String cname;
	private String caddress;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Set<Invoice> invoices=new TreeSet<Invoice>();
	
	public final String getCustomerId() {
		return customerId;
	}
	public final void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public final String getCname() {
		return cname;
	}
	public final void setCname(String cname) {
		this.cname = cname;
	}
	public final String getCaddress() {
		return caddress;
	}
	public final void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public final Set<Invoice> getInvoices() {
		return invoices;
	}
	public final void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}
	
}
