package com.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping("/api/autoconfig")
public class AutoConfigController {

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping("/test")
	public String testAutoConfig() {
		return "ObjectMapper class: " + objectMapper.getClass().getSimpleName() + " | INDENT_OUTPUT enabled: "
				+ objectMapper.isEnabled(SerializationFeature.INDENT_OUTPUT);
	}
}
