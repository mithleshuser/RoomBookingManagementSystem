package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.business.dao.Customerdao;
import com.example.demo.customer.Customer;

@SpringBootTest
public class CustomerSerrvicesTest {

	@Mock
	private Customerdao customerdao;

	@InjectMocks 
	private CustomerSerrvicesImlp customerSerrvicesImlp;
	
	

	@Test 
	public void saveCustomer() {
		Customer customer = new Customer(111L,"TestingMith", "Kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link@gmail.com1","pwd1");
		Boolean isSavetrue=true;
		Mockito.when(customerdao.saveCustomer(customer)).thenReturn(isSavetrue);
		Customer customer1 = customerSerrvicesImlp.saveCustomer(customer);
		assertEquals(customerSerrvicesImlp.saveCustomer(customer), customer1);
		assertEquals(customer1, customer);
	}
	

	@Test 
	public void saveCustomer2() {
		Customer customer = new Customer(101L,"TestingMith", "Kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link@gmail.com1","pwd1");
		Boolean isSaveFalse=false;
		Mockito.when(customerdao.saveCustomer(customer)).thenReturn(isSaveFalse);
		Customer customer1 = customerSerrvicesImlp.saveCustomer(customer);
		assertNull(customer1);

	}
	
	
	
	@Test //pass
	public void testFindCustomerById() {
		final Customer customer = new Customer(101L,"Dilip", "Kumar", new GregorianCalendar(1990, 12, 25).getTime(), "m.ctli.link@gmail.com1","pwd1");
		Mockito.when(customerdao.findById(101L)).thenReturn(customer);
		assertThat(customerSerrvicesImlp.findById(101L)).isEqualTo(customer);
		assertThat(customer).isNotNull();
		assertEquals(customerSerrvicesImlp.findById(101L), customer);
	}
	
	@Test
	public void testRetrieveAllCustomer() {
		Customer customer10 = new Customer("firstname", "lastname", new GregorianCalendar(1990, 12, 25).getTime(),
				"email", "password");
		Customer customer20 = new Customer("mithlesh", "kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link@gmail.com");
		Customer customer30 = new Customer("Birbal", "sagar", new GregorianCalendar(1990, 12, 25).getTime(), "email",
				"password");
		Customer customer1 = new Customer(101L, "Dilip", "kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link1@gmail.com", "pwd1");
		Customer customer2 = new Customer(102L, "mukesh", "kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link2@gmail.com", "pwd2");
		Customer customer3 = new Customer(103L, "rajesh", "kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link3@gmail.com", "pwd3");
		Customer customer4 = new Customer(104L, "birbal", "kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link4@gmail.com", "pwd4");
		Customer customer5 = new Customer(105L, "ram", "kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link5@gmail.com", "pwd5");
		Customer customer6 = new Customer(106L, "shyam", "kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link6@gmail.com", "pwd6");
		Customer customer7 = new Customer(107L, "ankit", "kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link7@gmail.com", "pwd7");

		Customer customer = new Customer();
		List<Customer> listOfCustomer = new ArrayList<>();
		customer.setId(11L);
		customer.setFirstname("Mukesh");
		customer.setFirstname("arya");
		customer.setEmail("mukesh1490@gmail.com");
		customer.setPassword("password");
		listOfCustomer.add(customer);
		listOfCustomer.add(customer10);
		listOfCustomer.add(customer20);
		listOfCustomer.add(customer30);
		listOfCustomer.add(customer1);
		listOfCustomer.add(customer2);
		listOfCustomer.add(customer3);
		listOfCustomer.add(customer4);
		listOfCustomer.add(customer5);
		listOfCustomer.add(customer6);
		listOfCustomer.add(customer7);

		Mockito.when(customerdao.findAll()).thenReturn(listOfCustomer);
		List<Customer> lstCus = customerSerrvicesImlp.findAll();
		assertThat(customerSerrvicesImlp.findAll()).isEqualTo(listOfCustomer);
		assertEquals(listOfCustomer, lstCus);
		assertThat(customerdao.findAll().isEmpty());

	}
}
