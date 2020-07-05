package com.example.demo.RestController;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.customer.Customer;
import com.example.demo.service.CustomerSerrvicesImlp;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerControllerTests {

	private MockMvc mockMvc;

	@InjectMocks
	private CustomerController customerController;

	@Mock
	private CustomerSerrvicesImlp customerSerrvices;

	@Before
	public void serUp() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new CustomerController()).build();
	}

	@Test
	public void saveCustomerAPIStatus() throws Exception {

		Customer customer = new Customer(111L, "TestingMith", "Kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link@gmail.com1", "pwd1");
		when(customerSerrvices.saveCustomer(customer)).thenReturn(customer);
		ResponseEntity<Object> customer1 = customerController.createPerson(customer);
		assertNotNull(customer1);
		assertEquals(HttpStatus.CREATED, customer1.getStatusCode());
	}

	@Test
	public void getCustomerAPIStatusFindById() throws Exception {
		Customer customer = new Customer(101L, "Dilip", "Kumar", new GregorianCalendar(1990, 12, 25).getTime(),
				"m.ctli.link@gmail.com1", "pwd1");
		when(customerSerrvices.findById(anyLong())).thenReturn(customer);
		ResponseEntity<Object> customer2 = customerController.findById(101L);
		assertNotNull(customer2.getStatusCode());
		assertEquals(HttpStatus.OK, customer2.getStatusCode());
	}

	@Test
	public void governmentNewsTest() throws Exception {
		String expectedMessage = "Coronavirus - Restaurants, Hotels To Be Closed Till October 15? Government's Fact Check ";
		when(customerSerrvices.getGovernmentNews()).thenReturn(expectedMessage);
		String actualMessage = customerController.getGovernmentNews();
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * As service is not running, we have written code for negative testing
	 * @throws Exception
	 */
	@Test
	public void testCustomerJSON_ResponceObject() throws Exception {
		this.mockMvc.perform(get("/request/api/customer/json"))
		.andDo(print())
		.andExpect(status().isNotFound());
	}


	@Test
	public void validate_response_status_code_403() {
		Header authorizationHeader = new Header("Authorization", "Bearer invalid-authorization-header");
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header(authorizationHeader);
		Response response = httpRequest.get("/acdefghijklmnopqrstuvwxyz");
		Assert.assertEquals(403, response.getStatusCode());
	}

}