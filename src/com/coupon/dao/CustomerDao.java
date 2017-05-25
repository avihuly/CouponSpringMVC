package com.coupon.dao;

import java.util.Collection;

import com.coupon.entities.Coupon;
import com.coupon.entities.Customer;

public interface CustomerDao {

	/**
	 * Creates a new Customer in a Database with the parameters of the given
	 * customer bean instance
	 * 
	 * @param custumer
	 *            An instance of a Bean Customer
	 * @throws CouponSystemException
	 * @throws IllegalPasswordException
	 * @throws CustomerAlreadyExistsException
	 */
	public void createCustomer(Customer custumer);

	/**
	 * Removes a Customer from the Database with the parameters of the given
	 * customer bean instance
	 * 
	 * @param custumer
	 *            An instance of a Bean Customer
	 * @throws CouponSystemException
	 * @throws CustomerDoesNotExistException
	 */
	public void removeCustomer(int id);

	/**
	 * Updates a Customer in the Database with the parameters of the given
	 * customer bean instance
	 * 
	 * @param custumer
	 *            An instance of a Bean Customer
	 * @throws CouponSystemException
	 * @throws IllegalPasswordException
	 * @throws CustomerAlreadyExistsException
	 */
	public void updateCustomer(Customer custumer);

	/**
	 * Returns an instance of a Bean Customer based on a giver Cutomer's ID
	 * 
	 * @param id
	 *            Existing Customer's ID
	 * @return An instance of a Bean Customer
	 * @throws CouponSystemException
	 * @throws CustomerAlreadyExistsException
	 */
	public Customer getCustomer(long id);

	/**
	 * Returns an instance of a Bean Customer based on a giver Cutomer's Name
	 * and Password
	 * 
	 * @param name
	 *            Existing Customer's Name
	 * @param password
	 *            Existing Customer's Password
	 * @return An instance of a Bean Customer
	 * @throws CouponSystemException
	 * @throws CustomerAlreadyExistsException
	 */
	public Customer getCustomer(String name, String password);

	/**
	 * Returns a Collection of all the Customer instances
	 * 
	 * @return Collection of Customer instances
	 * @throws CouponSystemException
	 */
	public Collection<Customer> getAllCustomer();

	/**
	 * Returns a Collection of all Coupon instances of a specific Customer
	 * instance
	 * 
	 * @param id
	 *            Existing Customer's ID
	 * @return Collection of Coupon instances
	 * @throws CouponSystemException
	 */
	public Collection<Coupon> getCoupons(long id);

	/**
	 * Returns a boolean indicating a successful login or not based on
	 * customer's given name and password as argument
	 * 
	 * @param custNmae
	 *            Customer's Name
	 * @param password
	 *            Customer's Password
	 * @return true for successful login and false for unsuccessful login
	 * @throws CouponSystemException
	 */
	public boolean login(String custNmae, String password);

}
