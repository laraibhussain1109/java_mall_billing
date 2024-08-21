package com.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.ItemSetBean;
import com.model.Item;

@Repository
public class ItemDAOImpl extends ItemDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public final SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Set<Item> getChosenItems(ItemSetBean itemSetBean) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Item.class);
		criteria.add(Restrictions.in("itemId", itemSetBean.getItems()));
		@SuppressWarnings("unchecked")
		List<Item> itemList=criteria.list();
		Set<Item> items=new HashSet<Item>();
		for(Item item:itemList) {
			System.out.println(item.getTrxs().isEmpty());
			items.add(item);
		}
		return items;
	}	
}
