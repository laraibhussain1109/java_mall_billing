package com.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Invoice;
import com.model.Item;
import com.model.Transaction;

@Repository
public class TransactionDAOImpl extends TransactionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public final SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean setTransaction(Invoice invoice, Set<Item> items) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.persist(invoice);
			for(Item item:items) {
				Transaction trx=new Transaction();
				trx.setInvoice(invoice);
				trx.setItem(item);
				trx.setQty(1);
				
				invoice.getTrxs().add(trx);
				item.getTrxs().add(trx);
				
				session.persist(trx);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
