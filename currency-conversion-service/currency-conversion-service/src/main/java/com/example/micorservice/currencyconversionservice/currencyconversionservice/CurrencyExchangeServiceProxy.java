package com.example.micorservice.currencyconversionservice.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url="localhost:9000")
// no need to give url after enabling ribbonClient..beacuse the url we will configure in adiff way
//we would not want it to talk to one perticular instance but we want to distribute the load
// we will configure the url for which this service has to distibute the load in appllication.properties
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
//this name will reflect in eureka naming server after registering this app
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getCurrency(@PathVariable String from, @PathVariable String to);
}
