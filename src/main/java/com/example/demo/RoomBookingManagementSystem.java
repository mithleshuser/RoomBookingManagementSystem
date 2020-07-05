package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RoomBookingManagementSystem {
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(RoomBookingManagementSystem.class, args);
	}

}