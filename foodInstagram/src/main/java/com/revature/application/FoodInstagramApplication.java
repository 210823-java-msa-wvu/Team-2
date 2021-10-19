package com.revature.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // allows auto configuration
@ComponentScan("com.revature") // alerts spring to look for components / stereotypes
@EnableJpaRepositories("com.revature.repository") //tells spring where to find our repos so hibernate can do its work
@EntityScan("com.revature.beans") // tells spring where our entities are
public class FoodInstagramApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodInstagramApplication.class, args);
	}

}
