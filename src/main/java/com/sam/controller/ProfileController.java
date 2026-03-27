package com.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	@Value("${app.env.message}")
	private String envMessage;

	@Autowired
	private Environment environment;

	@GetMapping("/info")
	public ResponseEntity<String> getProfileInfo() {
		String activeProfile = environment.getActiveProfiles()[0];
		return ResponseEntity.ok("Active Profile: " + activeProfile + " | Message: " + envMessage);
	}

}
