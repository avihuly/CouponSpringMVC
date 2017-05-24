package com.coupon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Customers")
public class Customer {
	//
	// Attributes
	//
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	//Constructors
	public Customer (){} 
	
	public Customer(long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public Customer(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	//
	// Methods - getters & setters
	//

	public long getId() {
		return id;
	}


	public String getCustName() {
		return name;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setId(long id) {
		this.id = id;
	}


	public void setCustName(String custName) {
		this.name = custName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//
	// other Methods
	//
	
	//toString
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + name + ", password=" + password + "]";
	}
	
	// HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	// Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}	
}