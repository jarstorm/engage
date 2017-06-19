package com.company.backend.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Expense {

	private long id;

	private String reason;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date;

	private String amount;

	private BigDecimal vat;
	
	public long getId() {
		return id;
	}

	public String getReason() {
		return reason;
	}

	public Date getDate() {
		return date;
	}

	public String getAmount() {
		return amount;
	}

	public BigDecimal getVat() {
		return vat;
	}
	
	public Expense() {
		// Jackson constructor
	}

	public Expense(long id, String reason, Date date, BigDecimal vat, String amount) {
		this.id = id;
		this.reason = reason;
		this.date = date;
		this.amount = amount;
		this.vat = vat;
	}

}
