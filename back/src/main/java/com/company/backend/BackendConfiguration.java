package com.company.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendConfiguration {
	
	@Value("${vat}")
	public Double vat;
	
	public Double getVat() {
		return vat;
	}
	
}
