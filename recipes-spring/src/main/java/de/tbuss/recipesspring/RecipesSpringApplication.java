package de.tbuss.recipesspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication(proxyBeanMethods = false)
@EnableJdbcRepositories
@EnableAutoConfiguration
public class RecipesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesSpringApplication.class, args);
	}

}
