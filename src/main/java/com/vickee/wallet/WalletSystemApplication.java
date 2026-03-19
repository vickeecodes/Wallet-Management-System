package com.vickee.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Wallet Management System", version = "1.0", description = "A Spring Boot REST API for secure user authentication and wallet management, featuring input validation, global exception handling, and Swagger documentation."))
@SpringBootApplication
public class WalletSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletSystemApplication.class, args);
	}
}
