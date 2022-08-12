package com.example.validation.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validation.demo.dto.UserDto;
import com.example.validation.demo.exception.UserNotFoundException;
import com.example.validation.demo.model.User;
import com.example.validation.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User createUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return userRepository.save(user);
	}

	public List<User> getALlUsers() {
		return userRepository.findAll();
	}

	public User getUser(long id) throws UserNotFoundException {
		User user = userRepository.findByUserId(id);
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("user not found with id : " + id);
		}
	}
}
