package com.service;

import java.util.Date;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gen;
import com.bean.ItemSetBean;
import com.dao.ItemDAO;
import com.dao.TransactionDAO;
import com.model.Customer;
import com.model.Invoice;
import com.model.Item;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private TransactionDAO trxDAO;
	
	public final TransactionDAO getTrxDAO() {
		return trxDAO;
	}

	public final void setTrxDAO(TransactionDAO trxDAO) {
		this.trxDAO = trxDAO;
	}

	public final ItemDAO getItemDAO() {
		return itemDAO;
	}

	public final void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public Set<Item> getChoosenItem(ItemSetBean itemSetBean) {
		Set<Item> items=itemDAO.getChosenItems(itemSetBean);
		return items;
	}
	public Invoice setInvoice(Customer customer) {

		Invoice invoice=new Invoice();
		invoice.setBillNo(Gen.getBillNo());
		invoice.setBillDate(new Date());
		invoice.setDiscount(0);
		invoice.setGst(0);
		invoice.setCustomer(customer);
		
		return invoice;
	}
	
	public boolean executeTransaction(Invoice invoice, Set<Item> items) {
		return trxDAO.setTransaction(invoice, items);
	}
}
