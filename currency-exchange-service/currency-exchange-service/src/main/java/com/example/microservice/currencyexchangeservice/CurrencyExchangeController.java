package com.example.microservice.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment env;

	@Autowired
	ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getCurrency(@PathVariable String from, @PathVariable String to){
		
		ExchangeValue c =  repository.findByFromAndTo(from, to);
		c.setPort(env.getProperty("local.server.port"));
		return c;
	}
}
