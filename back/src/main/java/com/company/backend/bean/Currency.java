package com.company.backend.bean;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Currency {

	private String base;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;

	private Map<String, Double> rates;
	
	public String getBase() {
		return base;
	}

	public Date getDate() {
		return date;
	}
	
	public Map<String, Double> getRates() {
		return rates;
	}
	
	public Currency() {
		// Jackson constructor
	}
}
