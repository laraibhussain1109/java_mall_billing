package com.dao;

import java.util.Set;

import com.model.Invoice;
import com.model.Item;

public abstract class TransactionDAO {
	public abstract boolean setTransaction(Invoice invoice, Set<Item> items);
}
