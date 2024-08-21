package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Customer;

@Repository
public class CustomerDAOImpl extends CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public final SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public Customer findUser(String customerId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Customer where customerId=:c");
		query.setParameter("c", customerId);
		
		Customer customer=(Customer) query.uniqueResult();
		return customer;
	}
}
