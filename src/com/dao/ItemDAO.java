package com.dao;

import java.util.Set;

import com.bean.ItemSetBean;
import com.model.Item;

public abstract class ItemDAO {
	public abstract Set<Item> getChosenItems(ItemSetBean itemSetBean);
}
