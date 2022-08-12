package com.example.validation.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.demo.dto.UserDto;
import com.example.validation.demo.exception.UserNotFoundException;
import com.example.validation.demo.model.User;
import com.example.validation.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * @param userDto URL : http://localhost:8080/api/users/signup
	 */
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto) {
		return new ResponseEntity<>(service.createUser(userDto), HttpStatus.CREATED);
	}

	/**
	 * URL : http://localhost:8080/api/users/fetchAll
	 */
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(service.getALlUsers());
	}

	/**
	 * @param id
	 * @return	
	 * @throws UserNotFoundException URL : http://localhost:8080/api/users/{id}
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) throws UserNotFoundException {
		return ResponseEntity.ok(service.getUser(id));
	}
}