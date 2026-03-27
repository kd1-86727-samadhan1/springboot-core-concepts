package com.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.config.PaymentProperties;

@RestController
@RequestMapping("/api/payment-config")
public class PaymentController {

	@Autowired
	private PaymentProperties paymentProperties;

	@GetMapping
	public ResponseEntity<PaymentProperties> getPaymentConfig() {
		return ResponseEntity.ok(paymentProperties);
	}
}
