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

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

//	@Bean
//	public CommandLineRunner run(@Autowired PasswordEncoder encoder) {
//		return args -> {
//			System.out.println("fetchivo - all in one downloader");
//			System.out.println("Encoded 'mahesh' : " + encoder.encode("mahesh"));
//		};
//	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("POST CONSTRUCT called - SpringBootApplicaton Class");
	}
}
