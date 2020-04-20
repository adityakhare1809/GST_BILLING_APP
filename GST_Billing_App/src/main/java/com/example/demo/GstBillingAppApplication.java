package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.demo.PRepository")
@SpringBootApplication
public class GstBillingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GstBillingAppApplication.class, args);
	}

}
