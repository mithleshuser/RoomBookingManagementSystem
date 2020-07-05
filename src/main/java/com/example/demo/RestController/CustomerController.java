package com.example.demo.RestController;

import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.Customer;
import com.example.demo.customer.Message;
import com.example.demo.service.CustomerSerrvices;
/**
 * This is Room Booking Management System for a Hotel chain and @RestController CustomerController class
 * @author Mithlesh
 *
 */

@RestController
@RequestMapping("/api")
public class CustomerController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerSerrvices customerSerrvices;

	/**
	 * Created a createPerson() method to Create operations for a customer through
	 * REST API which follows the POST request /api/customer to accept first name, last
	 * name , password  as JSON in the POST body and returns HTTP
	 * response 201 for successful creation
	 * and response 400 (bad request) when password does not fit
	 * the criteria or user name already exists
	 */

	
	@PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")//
	public <T> ResponseEntity<T> createPerson(@RequestBody Customer customer) {
		Customer resCustomer = customerSerrvices.saveCustomer(customer);
		if (resCustomer != null) {
			LOGGER.info("response 201 The request has been fulfilled and resulted in a new resource being created");
			Message message = new Message("Records created successfully", HttpStatus.CREATED);
			return (ResponseEntity<T>) new ResponseEntity<Customer>(resCustomer, HttpStatus.CREATED); 
																										
		} else {
			Message message = new Message("The request cannot be fulfilled due to bad request", HttpStatus.BAD_REQUEST);
			LOGGER.info("response 400 bad request when password does not fit");
			return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message); 
																									
		}
	}
	
	
	/**
	 * create a findById() method for get operations for a particular customer through
	 * REST API which follows the GET request /api/customer/{id} to retrieve matching customer details and
	 * it will return HTTP response 200 with retrieved customer information for
	 * successful match and  404 (resource not found) HTTP response for non matching username found.
	 * 
	 * @param id
	 * @return
	 */
	
	@GetMapping(value = "/customer/{id}", produces = "application/json")
	public <T> ResponseEntity<T> findById(@PathVariable Long id) {
		LOGGER.info("Customer Find By Id");
		Customer customer = customerSerrvices.findById(id);
		if (customer != null) {
			LOGGER.info("The request has been accepted for processing");
			return (ResponseEntity<T>) new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else{
			LOGGER.info("The request has been not accepted for processing");
			Message message = new Message("The requested resource could not be found.", HttpStatus.NOT_FOUND);
			return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}

	@GetMapping(value = "/customers/{id}")
	public Customer findByIds(@PathVariable Long id) {
		LOGGER.info("Customer Find By Id");
		Customer customer = customerSerrvices.findById(id);
		return customer;
	}

	@GetMapping("/hello")
	public String getGovernmentNews() {
		String helloString = customerSerrvices.getGovernmentNews();
		return helloString;
	}

	@GetMapping(value = "/customer/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer retrieveCustomer() {
		Customer customer =customerSerrvices.retrieveCustomerJsonObj();
		return customer;
	}

	@GetMapping("/allcustomer")
	public List<Customer> retrieveAllCustomer() {
		return customerSerrvices.findAll();
	}
	
	

}