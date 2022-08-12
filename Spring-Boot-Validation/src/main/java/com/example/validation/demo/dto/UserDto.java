package com.example.validation.demo.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@Column(name = "name", nullable = false)
	@NotEmpty
	@Size(min = 2, message = "user name should have at least 2 characters")
	private String userName;

	@NotEmpty
	@Email(message = "invalid email address")
	private String userEmail;

	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 characters")
	private String userPassword;

	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
	private String mobile;

	@NotBlank
	private String gender;

	@Min(18)
	@Max(60)
	private int age;
	
	@NotBlank
	private String nationality;

}
