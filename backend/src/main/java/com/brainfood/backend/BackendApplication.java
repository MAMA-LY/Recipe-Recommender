package com.brainfood.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;


@ComponentScan(basePackages = {"com.brainfood.backend", "com.brainfood.security", "com.brainfood.repository"})
@EntityScan("com.brainfood.entities")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories("com.brainfood.repository")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
