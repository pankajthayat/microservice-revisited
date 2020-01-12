package com.example.microservice.nerflixeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // to enable naming server
public class NerflixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NerflixEurekaServerApplication.class, args);
	}

}
