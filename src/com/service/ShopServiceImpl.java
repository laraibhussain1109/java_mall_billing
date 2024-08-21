package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ShopDAO;
import com.model.Shop;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDAO shopDAO;
	
	public final ShopDAO getShopDAO() {
		return shopDAO;
	}

	public final void setShopDAO(ShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}

	public List<Shop> getAllShops(){
		List<Shop> shops=shopDAO.getAllShops();
		return shops;
	}
}
