package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.customer.Customer;

public interface CustomerSerrvices {
	
	Customer findById(Long id);
	List<Customer> findAll();
	Customer saveCustomer(Customer customer);
	String getGovernmentNews();
	Customer findByUsserName(String username);
	
	
	//Customer create(Customer account);
	//Customer update(String id, Customer cus);
	//int delete(String id);
}
