package com.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.sam") // @ConfigurationPropertiesScan on main class
										// Remove @Component from AppProperties
public class SpringbootCoreConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCoreConceptsApplication.class, args);
	}

}
