package com.example.demo.RestController;


import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRestApiTest {
	
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8086;
	}


    @Test
    public void testCustomerFetchById() {
        get("/request/api/customers/101")
        .then()
        .body("id", equalTo(101))
        .body("firstname", equalTo("Dilip"))
        .body("lastname", equalTo("Kumar"))
        .body("email", equalTo("m.ctli.link@gmail.com1"));
    }
    
    
    @Test
    public void testCustomerFetchesSuccess() {
        get("/request/api/customer/mukesh")
        .then()
        .body("id", equalTo(1))
        .body("firstname", equalTo("mukesh"))
        .body("lastname", equalTo("arya"))
        .body("email", equalTo("mukesh@gmail.com"))
        .body("password", equalTo("password3"));
    }
    
    
    
}
    