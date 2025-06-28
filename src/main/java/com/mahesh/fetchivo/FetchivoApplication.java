package com.mahesh.fetchivo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.mahesh.fetchivo.repository")
public class FetchivoApplication {
	public static void main(String[] args) {
		System.out.println("fetchivo - all in one downloader");
		SpringApplication.run(FetchivoApplication.class, args);
	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("POST CONSTRUCT called - Spring Boot Application Class");
	}
}
