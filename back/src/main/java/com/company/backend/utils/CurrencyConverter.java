package com.company.backend.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.company.backend.bean.Currency;

@Component
public class CurrencyConverter {

	private static Currency currency;

	public static Double getConversionRateInGBP() {
		if (currency == null) {
			initialize();
		}
		return currency.getRates().get("GBP");
	}

	private static void initialize() {
		RestTemplate restTemplate = new RestTemplate();
		currency = restTemplate.getForObject("http://api.fixer.io/latest?symbols=GBP", Currency.class);
	}

}
