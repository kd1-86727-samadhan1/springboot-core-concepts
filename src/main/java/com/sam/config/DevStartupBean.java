package com.sam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevStartupBean implements ApplicationRunner {

	@Autowired
	private Environment environment;

	@Override
	public void run(ApplicationArguments args) {

		// Gets actual active profile at runtime!
		String activeProfile = environment.getActiveProfiles()[0];
		System.out.println("**********************************");
		System.out.println("DEV BEAN LOADED SUCCESSFULLY!");
//		System.out.println("Profile: dev is ACTIVE");
		System.out.println("Profile: " + activeProfile + " is ACTIVE");
		System.out.println("Task 4 - @Profile demo");
		System.out.println("**********************************");
	}
}
