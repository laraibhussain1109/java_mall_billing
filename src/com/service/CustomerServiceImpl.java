package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDAO;
import com.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDAO customerDAO;
	
	public final CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public final void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public Customer getCustomer(String customerId) {
		Customer customer=customerDAO.findUser(customerId);
		return customer;
	}
}
