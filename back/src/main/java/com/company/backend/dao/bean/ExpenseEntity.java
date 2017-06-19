package com.company.backend.dao.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.company.backend.bean.Expense;

@Entity // This tells Hibernate to make a table out of this class
public class ExpenseEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String reason;
	private Date date;
	private BigDecimal vat;
	private BigDecimal amount;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getVat() {
		return vat;
	}
	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public ExpenseEntity() {		
	}
	
	public ExpenseEntity(Expense expense, BigDecimal amount, BigDecimal vat) {
		if (expense != null) {
			this.id = expense.getId();
			this.date = expense.getDate();
			this.amount = amount;
			this.vat = vat;
			this.reason = expense.getReason();
		}
	}	
}
