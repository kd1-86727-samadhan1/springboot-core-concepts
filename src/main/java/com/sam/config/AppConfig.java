package com.sam.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sam.service.impl.FeatureServiceImpl;

@Configuration
public class AppConfig {

	// Task 1 - ObjectMapper @Bean
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper;
	}

	// Task 2 - @ConditionalOnProperty
	@Bean
	@ConditionalOnProperty(
				name = "myapp.feature.enabled",
				havingValue = "true",
				matchIfMissing = false
			)
	public FeatureServiceImpl featureService() {
		return new FeatureServiceImpl();
	}

}
