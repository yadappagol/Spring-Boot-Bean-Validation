package com.example.validation.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validation.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(long id);
}
