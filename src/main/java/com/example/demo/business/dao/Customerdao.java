package com.example.demo.business.dao;

import java.util.List;

import com.example.demo.customer.Customer;

public interface Customerdao {

	Customer findById(Long id);

	List<Customer> findAll();

	boolean saveCustomer(Customer customer);

	Customer findByUsserName(String username);


}
