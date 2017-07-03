package com.coupon.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coupon.entities.Customer;

@Controller
public class TestController {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@RequestMapping(value = "/helloCustomer/{name}/{password}/{email}")
	@ResponseBody
	private String helloCustomer(@PathVariable(value = "name") String name,
			@PathVariable(value = "password") String password) {

		try {
			session = sessionFactory.getCurrentSession();

			session.getTransaction().begin();

			Customer customer = new Customer(name, password);

			session.persist(customer);

			session.getTransaction().commit();

			return "Customer - " + customer;
		} catch (Exception e) {
			return "Customer could not be persist";
		} finally {
			session.close();
		}
	}

	@RequestMapping(value = "/getCustomersByName/{name}")
	@ResponseBody
	private Customer getCustomersByName(@PathVariable(value = "name") String name) {
		try {
			session = sessionFactory.getCurrentSession();
			
			session.getTransaction().begin();
			
			String hql = "FROM Customer C";
			Query query = session.createQuery(hql, Customer.class);
			List<Customer> results = query.getResultList();

			session.getTransaction().commit();
			
			return results.get(0);

		} catch (Exception e) {
			System.out.println("****************");
			System.out.println("****************");
			System.out.println(e.getMessage());
			System.out.println("****************");
			System.out.println("****************");
			return null;
		} finally {
			session.close();
		}
	}

}
