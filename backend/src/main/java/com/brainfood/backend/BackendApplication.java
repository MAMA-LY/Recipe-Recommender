package com.brainfood.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.brainfood.backend", "com.brainfood.security" , "com.brainfood.search"})
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
