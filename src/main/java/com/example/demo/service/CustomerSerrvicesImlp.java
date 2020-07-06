package com.example.demo.service;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.dao.Customerdao;
import com.example.demo.customer.Customer;

@Service
public class CustomerSerrvicesImlp implements CustomerSerrvices {

	@Autowired
	private Customerdao customerdao;

	@Override
	public Customer findById(Long id) {
		Customer customer = customerdao.findById(id);
		return customer;
	}
	@Override
	public Customer findByUsserName(String username) {
		Customer customer = customerdao.findByUsserName(username);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customer = customerdao.findAll();
		return customer;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean isSaved = customerdao.saveCustomer(customer);
		if (isSaved) {
			return customer;
		}
		return null;
	}

	@Override
	public String getGovernmentNews() {
		// TODO Auto-generated method stub
		return "Coronavirus - Restaurants, Hotels To Be Closed Till October 15? Government's Fact Check";
	}



}
