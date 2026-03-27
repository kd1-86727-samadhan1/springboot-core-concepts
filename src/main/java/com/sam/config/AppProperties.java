package com.sam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	private String name;
	private String version;
	private int timeout;
	private int maxRetries;
	private String baseUrl;
}
