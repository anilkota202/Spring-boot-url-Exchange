package com.capg.cap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;
@EnableWebSecurity
@SpringBootApplication (scanBasePackages ="com.capg.*")
public class CapApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapApplication.class, args);
	}
	 @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }

}
