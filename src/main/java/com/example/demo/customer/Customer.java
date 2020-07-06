package com.example.demo.customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * It is entity for storage of customer 
 * @author Mithlesh
 *
 */
@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Firstname", length = 50, unique=true,  nullable = false)
	private String firstname;

	@Column(name = "Lastname", length = 50)
	private String lastname;

	@Column(name = "Dob", length = 100)
	private Date dob; // ReqestTime : datetime

	@Column(name = "Email", length = 50)
	private String email;

	@Column(name = "password", length = 50)
	private String password;

	public Customer() {
		super();
	}

	public Customer(String firstname, String lastname, Date dob, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
	}

	public Customer(String firstname, String lastname, Date dob, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}

	public Customer(Long id, String firstname, String lastname, Date dob, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", email=" + email + ", password=" + password + "]";
	}

}
