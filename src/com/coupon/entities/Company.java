package com.coupon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {
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
	
	@Column(name = "EMAIL")
	private String email;

	// Constructors
	public Company() {}; 

	public Company(long id, String compName, String password, String email) {
		this.id = id;
		this.name = compName;
		this.password = password;
		this.email = email;
	}

	public Company(String compName, String password, String email) {
		this.name = compName;
		this.password = password;
		this.email = email;
	}

	//
	// Methods - getters & setters
	//	
	public long getId() {
		return id;
	}

	
	public String getCompName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	// toString
	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + name + ", password=" + password + ", email=" + email + "]";
	}

	// HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Company other = (Company) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}