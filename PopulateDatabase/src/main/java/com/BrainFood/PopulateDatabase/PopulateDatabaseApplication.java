package com.BrainFood.PopulateDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.*")
@EnableJpaRepositories("com.BrainFood.Repositories")
@EntityScan("com.BrainFood.DatabaseEntities")
@SpringBootApplication
public class PopulateDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopulateDatabaseApplication.class, args);
	}

}
