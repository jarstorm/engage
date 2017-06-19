package com.company.backend.utils;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.company.backend.bean.Expense;

public class CalculationUtilsTest {
	
	@Test
	public void testCalculateAmountGBP() throws Exception {
		Expense expense = new Expense(1, "", new Date(), new BigDecimal(0.2), "10");
		BigDecimal amount = CalculationUtils.calculateAmount(expense);
		Assert.assertEquals(amount, new BigDecimal(10));
	}
	
	@Test
	public void testCalculateAmountGBP0() throws Exception {
		Expense expense = new Expense(1, "", new Date(), new BigDecimal(0.2), "0");
		BigDecimal amount = CalculationUtils.calculateAmount(expense);
		Assert.assertEquals(amount, new BigDecimal(0));
	}
	
	@Test
	public void testCalculateAmountEUR() throws Exception {
		Expense expense = new Expense(1, "", new Date(), new BigDecimal(0.2), "10 EUR");
		BigDecimal amount = CalculationUtils.calculateAmount(expense);
		Assert.assertEquals(amount, new BigDecimal(10).multiply(new BigDecimal(CurrencyConverter.getConversionRateInGBP())));
	}
	
	@Test
	public void testCalculateAmountEUR_1() throws Exception {
		Expense expense = new Expense(1, "", new Date(), new BigDecimal(0.2), "10EUR");
		BigDecimal amount = CalculationUtils.calculateAmount(expense);
		Assert.assertEquals(amount, new BigDecimal(10).multiply(new BigDecimal(CurrencyConverter.getConversionRateInGBP())));
	}
	
	@Test
	public void testCalculateAmountEUR_2() throws Exception {
		Expense expense = new Expense(1, "", new Date(), new BigDecimal(0.2), "10  EUR ");
		BigDecimal amount = CalculationUtils.calculateAmount(expense);
		Assert.assertEquals(amount, new BigDecimal(10).multiply(new BigDecimal(CurrencyConverter.getConversionRateInGBP())));
	}
	
	@Test
	public void testCalculateAmountEUR0() throws Exception {
		Expense expense = new Expense(1, "", new Date(), new BigDecimal(0.2), "0 EUR");
		BigDecimal amount = CalculationUtils.calculateAmount(expense);
		Assert.assertEquals(amount, new BigDecimal(0).multiply(new BigDecimal(CurrencyConverter.getConversionRateInGBP())));
	}
	
	@Test
	public void testCalculateAmountNull() throws Exception {
		Expense expense = new Expense(1, "", new Date(), new BigDecimal(0.2), null);
		BigDecimal amount = CalculationUtils.calculateAmount(expense);
		Assert.assertEquals(amount, new BigDecimal(0));
	}
	
	@Test
	public void testCalculateVat() throws Exception {
		Expense expense = new Expense(1, "", new Date(), null, "10");
		BigDecimal vat = CalculationUtils.calculateVat(expense, 0.2);
		Assert.assertEquals(vat, new BigDecimal("2.0"));
	}
	
	@Test
	public void testCalculateVat0() throws Exception {
		Expense expense = new Expense(1, "", new Date(), null, "10");
		BigDecimal vat = CalculationUtils.calculateVat(expense, 0);
		Assert.assertEquals(vat, new BigDecimal("0.0"));
	}
	
	@Test
	public void testCalculateVatNull() throws Exception {
		Expense expense = new Expense(1, "", new Date(), null, "10");
		BigDecimal vat = CalculationUtils.calculateVat(expense, 0);
		Assert.assertEquals(vat, new BigDecimal("0.0"));
	}
}
