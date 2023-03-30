package com.example.ecommerce.configuration.mappers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	@Bean
	public AppConfiguration modelMapper() {

		return new AppConfiguration();
	}
}
