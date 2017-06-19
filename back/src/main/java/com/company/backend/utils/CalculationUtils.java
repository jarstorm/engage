package com.company.backend.utils;

import java.math.BigDecimal;

import com.company.backend.bean.Expense;

public class CalculationUtils {

	public static BigDecimal calculateAmount(Expense expense) {
		BigDecimal amountValue = new BigDecimal(0);
		if (expense.getAmount() != null) {
			if (expense.getAmount().contains("EUR")) {
				String value = expense.getAmount().split("EUR")[0];
				if (value != null) {
					amountValue = new BigDecimal(value.trim())
							.multiply(new BigDecimal(CurrencyConverter.getConversionRateInGBP()));
				}
			} else {
				amountValue = new BigDecimal(expense.getAmount());
			}
		}
		return amountValue;
	}

	public static BigDecimal calculateVat(Expense expense, double vatConfigurationValue) {
		BigDecimal vat = new BigDecimal(0);
		if (expense.getAmount() != null) {
			vat = CalculationUtils.calculateAmount(expense)
					.multiply(new BigDecimal(String.valueOf(vatConfigurationValue)));
		}
		return vat;
	}

}
