package com.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.dto.UserRegistrationRequest;
import com.sam.entity.User;
import com.sam.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserRegistrationRequest request) {

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userService.registerUser(request));
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
	}

}
