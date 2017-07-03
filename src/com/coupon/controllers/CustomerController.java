package com.coupon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coupon.dao.CustomerDao;
import com.coupon.entities.Customer;

@Controller 
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	@Qualifier ("customerDao")
	private CustomerDao customerDao;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Customer createCustomer (@RequestBody Customer customer){
		
		customerDao.createCustomer(customer);
		
		return customer;
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public @ResponseBody Customer removeCustomer (@PathVariable(value = "id") int id){
		
		// Customer customer = customerDao.getCustomer(id);
		Customer customer = new Customer(26,"AAAA","aaaa");
		customerDao.removeCustomer(id);
		
		return customer;
	}
	
	
}
