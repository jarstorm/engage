package com.company.backend.service;

import java.util.List;

import com.company.backend.bean.Expense;

public interface ExpenseService {

	List<Expense> findAll();

	void save(Expense expense);

}
