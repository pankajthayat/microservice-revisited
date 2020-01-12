package com.example.microservice.nerflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

//this app is ouw zuul server
@EnableZuulProxy
@EnableDiscoveryClient//we want this to register to naming server
@SpringBootApplication

public class NerflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NerflixZuulApiGatewayServerApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}



//steps:
//1) we have to configure it and register it with the naming server
//2) configure what should it do when it intercepts a request


//here we will log every request that comes through the gateway
