package com.example.demo.business.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.customer.Customer;

@Repository
public class CustomerdaoImpl implements Customerdao {
	private static Customer customer1;
	private static Customer customer2;
	private static Customer customer3;
	private static HashMap<Long, Customer> customerContainer;
	static {
		Customer customer1 = new Customer(101L,"Dilip", "Kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link@gmail.com1","pwd1");
		Customer customer2 = new Customer(102L,"mukesh", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link2@gmail.com","pwd2");
		Customer customer3 = new Customer(103L,"rajesh", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link3@gmail.com","pwd3");
		Customer customer4 = new Customer(104L,"birbal", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link4@gmail.com","pwd4");
		Customer customer5 = new Customer(105L,"ram", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link5@gmail.com","pwd5");
		Customer customer6 = new Customer(106L,"shyam", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link6@gmail.com","pwd6");
		Customer customer7 = new Customer(107L,"ankit", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link7@gmail.com","pwd7");
		customerContainer = new HashMap<>();
		customerContainer.put(101L, customer1);
		customerContainer.put(102L, customer2);
		customerContainer.put(103L, customer3);
		customerContainer.put(104L, customer4);
		customerContainer.put(105L, customer5);
		customerContainer.put(106L, customer6);
		customerContainer.put(107L, customer7);
	}
	@Override
	public boolean saveCustomer(Customer customer) {
		long c_id = customer.getId();

		if (customerContainer.containsKey(c_id)) {
			return false;
		} else {
			customerContainer.put(c_id, customer);
		}
		return true;
	}

	@Override
	public Customer findById(Long id) {
		if (customerContainer.containsKey(id)) {
			Customer customer = customerContainer.get(id);
			return customer;
		} 
		return null;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customer = new ArrayList<>();
		for (Customer v : customerContainer.values()) {
			customer.add(v);
		}
		return customer;
	}
}
