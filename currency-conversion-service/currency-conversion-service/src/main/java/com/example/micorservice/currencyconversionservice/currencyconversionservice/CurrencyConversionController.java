package com.example.micorservice.currencyconversionservice.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyExchangeServiceProxy proxy;
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariable = new HashMap<String, String>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
	//	uriVariable.put("quantity", quantity); 
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity(
				"http://localhost:9000/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversionBean.class,
				uriVariable);
		CurrencyConversionBean responseBean =  response.getBody();
		
		logger.info("{}",responseBean);
		return new CurrencyConversionBean(responseBean.getId(),
				from,to,
				responseBean.getConversionMultiple(),
				quantity,
				quantity.multiply(responseBean.getConversionMultiple()),
				responseBean.getPort());
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean responseBean =  proxy.getCurrency(from, to);
		
		return new CurrencyConversionBean(responseBean.getId(),
				from,to,
				responseBean.getConversionMultiple(),
				quantity,
				quantity.multiply(responseBean.getConversionMultiple()),
				responseBean.getPort());
	}
}
