package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Item;
import com.model.Shop;

@Repository
public class ShopDAOImpl extends ShopDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public final SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Shop> getAllShops(){
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Shop.class);
		@SuppressWarnings("unchecked")
		List<Shop> shops=criteria.list();
		//for reference
		for(Shop shop:shops) {
			shop.getShopName();
			for(Item item:shop.getItems()) {
				item.getItemDescription();
			}
		}
		return shops;
	}
}
