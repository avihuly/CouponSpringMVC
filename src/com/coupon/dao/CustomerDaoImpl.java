package com.coupon.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.coupon.entities.Coupon;
import com.coupon.entities.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	// @Autowired
	private SessionFactory sessionFactory;

	// Only for test with local app
//	private SessionFactory sessionFactory = new Configuration()
//			.configure()
//			.buildSessionFactory();
//	
	
	private Session session;

	@Override
	public void createCustomer(Customer customer) {

		session = sessionFactory.getCurrentSession();

		session.getTransaction().begin();

		session.persist(customer);

		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeCustomer(long id) {

		Customer customer;

		session = sessionFactory.getCurrentSession();

		session.getTransaction().begin();

		customer = session.load(Customer.class, id);

		session.delete(customer);

		session.getTransaction().commit();

		session.close();

	}

	@Override
	public void updateCustomer(Customer customer) {
		session = sessionFactory.getCurrentSession();

		session.getTransaction().begin();

		customer = session.load(Customer.class, customer.getId());

		session.merge(customer);

		session.getTransaction().commit();

		session.close();

	}

	@Override
	public Customer getCustomer(long id) {

		Customer customer;

		session = sessionFactory.getCurrentSession();

		session.getTransaction().begin();

		customer = session.load(Customer.class, id);

		session.getTransaction().commit();

		session.close();

		return customer;
	}

	@Override
	public Customer getCustomer(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Coupon> getCoupons(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String custNmae, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
