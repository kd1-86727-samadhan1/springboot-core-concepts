package com.sam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.dto.UserRegistrationRequest;
import com.sam.entity.User;
import com.sam.exception.AppException;
import com.sam.repository.UserRepository;
import com.sam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(UserRegistrationRequest request) {
		
		if(userRepository.existsByEmail(request.getEmail())) {
			throw new AppException("EMAIL_ALREADY_EXISTS",
					"EMAIL already registered: " + request.getEmail());
		}
		// Map DTO to Entity
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new AppException(
						"USER_NOT_FOUND",
						"User not found with ID: " + id
						));
	}
}
