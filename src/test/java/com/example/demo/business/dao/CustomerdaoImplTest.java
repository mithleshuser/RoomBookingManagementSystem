package com.example.demo.business.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.customer.Customer;

public class CustomerdaoImplTest {
	
	@Autowired
	private Customerdao customerdao;

	@Autowired
	private CustomerdaoImpl customerdaoImp;

	@Test
	public void testRetrieveAllCustomer() {
		
		Customer customer11 = new Customer("firstname", "lastname", new GregorianCalendar(1990, 12, 25).getTime(), "email", "password");
		Customer customer21 = new Customer("mithlesh", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link@gmail.com");
		Customer customer31 = new Customer("Birbal", "sagar", new GregorianCalendar(1990, 12, 25).getTime(),"email","password");
		Customer customer = new Customer();
		List<Customer> listOfCustomer = new ArrayList<>();
		customer.setId(11L);
		customer.setFirstname("Mukesh");
		customer.setFirstname("arya");
		customer.setEmail("mukesh1490@gmail.com");
		customer.setPassword("password");
		Customer customer1 = new Customer(101L,"Dilip", "Kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link@gmail.com1","pwd1");
		Customer customer2 = new Customer(102L,"mukesh", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link2@gmail.com","pwd2");
		Customer customer3 = new Customer(103L,"rajesh", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link3@gmail.com","pwd3");
		Customer customer4 = new Customer(104L,"birbal", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link4@gmail.com","pwd4");
		Customer customer5 = new Customer(105L,"ram", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link5@gmail.com","pwd5");
		Customer customer6 = new Customer(106L,"shyam", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link6@gmail.com","pwd6");
		Customer customer7 = new Customer(107L,"ankit", "kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link7@gmail.com","pwd7");
	
		listOfCustomer.add(customer1);
		listOfCustomer.add(customer2);
		listOfCustomer.add(customer3);
		listOfCustomer.add(customer4);
		listOfCustomer.add(customer5);
		listOfCustomer.add(customer6);
		listOfCustomer.add(customer7);
		
	}

}
