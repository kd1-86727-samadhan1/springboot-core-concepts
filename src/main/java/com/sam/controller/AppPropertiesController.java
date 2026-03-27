package com.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.config.AppProperties;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/app-properties")
public class AppPropertiesController {

	@Autowired
	private AppProperties appProperties;

	@GetMapping
	public ResponseEntity<AppProperties> getAppProperties() {
		return ResponseEntity.ok(appProperties);
	}

}
