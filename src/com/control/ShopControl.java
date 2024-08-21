package com.control;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.ItemSetBean;
import com.model.Customer;
import com.model.Invoice;
import com.model.Item;
import com.model.Shop;
import com.service.OrderService;
import com.service.ShopService;

@Controller
public class ShopControl {
	@Autowired
	private ShopService shopService;
	@Autowired
	private OrderService orderService;
	
	public final OrderService getOrderService() {
		return orderService;
	}

	public final void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public final ShopService getShopService() {
		return shopService;
	}

	public final void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}


	@ModelAttribute("allshops")
	public List<Shop> getAllShops(ModelAndView mandv, HttpServletRequest request){
		List<Shop> shops=shopService.getAllShops();
		return shops;
	}	
	
	@RequestMapping(value = "/loadshop", method = RequestMethod.GET)
	public ModelAndView getShop(ModelAndView mandv, HttpServletRequest request) {
		ItemSetBean itemSetBean=new ItemSetBean();
		mandv.addObject("itemsBean", itemSetBean);
		mandv.setViewName("shop");
		return mandv;
	}
	
	@RequestMapping(value="/placeorder", method = RequestMethod.POST)
	public ModelAndView placeOrder(ModelAndView mandv, HttpServletRequest request, ItemSetBean itemSetBean) {
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("customer");
		
		Set<Item> items=orderService.getChoosenItem(itemSetBean);
		Invoice invoice=orderService.setInvoice(customer);
		
		boolean success=orderService.executeTransaction(invoice, items);
		
		if(success) {
			session.setAttribute("invoice", invoice);
			session.setAttribute("items", items);
			mandv.setViewName("invoice");
			return mandv;
		}else {
			mandv.setViewName("error");
			return mandv;
		}
	}	
}
