package com.example.demo.customer;

import org.springframework.http.HttpStatus;

public class Message {

	private String message;
	private HttpStatus status;

	public Message(String message, HttpStatus created) {
		super();
		this.message = message;
		this.status = created;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
