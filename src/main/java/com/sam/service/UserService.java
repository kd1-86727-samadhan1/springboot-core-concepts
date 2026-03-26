package com.sam.service;

import com.sam.dto.UserRegistrationRequest;
import com.sam.entity.User;

public interface UserService {

	// Task 7 - takes DTO not Entity
	User registerUser(UserRegistrationRequest request);

	// Task 9- Get user by ID
	User getUserById(Long id);
}
