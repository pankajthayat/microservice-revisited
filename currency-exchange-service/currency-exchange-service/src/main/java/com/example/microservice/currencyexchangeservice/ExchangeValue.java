package com.example.microservice.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ExchangeValue {

	@Id
	private long id;
	
	@Column(name = "currency_from")
	private String from;
	
	@Column(name = "currency_to")
	private String to;
	
	@Column(name="conversion_Multiple")
	private long conversionMultiple;
	
	private String port;
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public ExchangeValue() {
		// TODO Auto-generated constructor stub
	}

	public ExchangeValue(long id, String from, String to, long conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public long getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(long conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
	
	
}
