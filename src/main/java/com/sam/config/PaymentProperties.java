package com.sam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "payment")
public class PaymentProperties {

	private boolean enabled;

	private Retry retry = new Retry();

	private Security security = new Security();

	// ***** Nested class: Retry *****
	@Data
	@NoArgsConstructor
	public static class Retry {
		private int maxAttempts;
		private Backoff backoff = new Backoff();

		@Data
		@NoArgsConstructor
		public static class Backoff {
			private long delay;
			private double multiplier;
		}
	}

	// ***** Nested class: Security *****
	@Data
	@NoArgsConstructor
	public static class Security {
		private String apiKey;
		private Hmac hmac = new Hmac();

		// ***** Nested class: Hmac *****
		@Data
		@NoArgsConstructor
		public static class Hmac {
			private boolean enabled;
			private String algorithm;
		}
	}
}
