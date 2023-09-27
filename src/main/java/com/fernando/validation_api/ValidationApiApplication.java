package com.fernando.validation_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidationApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ValidationApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server is running in http://localhost:8080/");
		
	}

	

}
