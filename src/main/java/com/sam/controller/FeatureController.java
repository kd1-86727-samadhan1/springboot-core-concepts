package com.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.service.FeatureService;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {

	@Autowired(required = false)
	private FeatureService featureService;

	@GetMapping("/status")
	public ResponseEntity<String> featureStatus() {
		if (featureService != null) {
			return ResponseEntity.ok(featureService.getFeatureMessage());
		} else {
			return ResponseEntity.ok("Feature is DISABLED - myapp.feature.enabled=false");
		}
	}
}
