package com.brainfood.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.brainfood.security.EmailSender;


@ComponentScan(basePackages = {"com.brainfood.backend", "com.brainfood.security"})
@SpringBootApplication(/*exclude = { SecurityAutoConfiguration.class }*/)
@EntityScan({"com.brainfood.backend", "com.brainfood.security"})
@EnableJpaRepositories("com.brainfood.security")
public class BackendApplication {

	@Autowired
	EmailSender emailSender;	

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

	// @EventListener(ApplicationReadyEvent.class)
	// public void sendEmail() {
	// 	emailSender.sendEmail("muhammad175ib59@gmail.com", "hello BrainFood", "I am hungry");
	// }

}
