package com.dao;

import com.model.Customer;

public abstract class CustomerDAO {
	public abstract Customer findUser(String customerId);
}
