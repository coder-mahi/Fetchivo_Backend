package com.mahesh.fetchivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
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

}
