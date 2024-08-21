package com.service;

import java.util.Set;

import com.bean.ItemSetBean;
import com.model.Customer;
import com.model.Invoice;
import com.model.Item;

public interface OrderService {
	public Set<Item> getChoosenItem(ItemSetBean itemSetBean);
	public Invoice setInvoice(Customer customer);
	public boolean executeTransaction(Invoice invoice, Set<Item> items);
}
