package com.gfi.academy.restfulservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.gfi.academy.restfulservices.repository")
public class RestfulServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServicesApplication.class, args);
	}
}
