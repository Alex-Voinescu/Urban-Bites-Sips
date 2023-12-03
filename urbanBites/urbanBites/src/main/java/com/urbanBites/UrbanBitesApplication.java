package com.urbanBites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.urbanBites.Model")
@EnableJpaRepositories(basePackages = "com.urbanBites.Repository")
public class UrbanBitesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbanBitesApplication.class, args);
		}

}