package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.LoginFormBean;
import com.model.Customer;
import com.service.CustomerService;

@Controller
public class LoginController {
	@Autowired
	private CustomerService customerService;
	
	public final CustomerService getCustomerService() {
		return customerService;
	}

	public final void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginForm(ModelAndView mandv, HttpServletRequest request) {
		LoginFormBean formBean=new LoginFormBean();
		mandv.addObject("formBean", formBean);
		mandv.setViewName("login");
		return mandv;
	}
	
	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	public ModelAndView authCustomer(ModelAndView mandv, LoginFormBean loginFormBean, HttpServletRequest request) {
		String customerId=loginFormBean.getCustomerId();
		Customer customer=customerService.getCustomer(customerId);
		HttpSession session = null;
		if(customer!=null) {
			session=request.getSession();
			session.setAttribute("customer", customer);
			session.setMaxInactiveInterval(30);
			mandv.setViewName("welcome");
			return mandv;
			
		}else {
			System.out.println("customer doesn't exist");
			mandv.setViewName("login");
			return mandv;
		}
	}
}
