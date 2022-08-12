package com.example.validation.demo.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	public UserNotFoundException(String message) {
		super(message);
	}
}
