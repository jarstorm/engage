package com.company.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.backend.BackendConfiguration;
import com.company.backend.bean.Expense;
import com.company.backend.dao.bean.ExpenseEntity;
import com.company.backend.dao.repository.ExpenseRepository;
import com.company.backend.utils.CalculationUtils;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private BackendConfiguration configuration;

	@Override
	public List<Expense> findAll() {
		List<Expense> list = new ArrayList<>();
		Iterable<ExpenseEntity> expenses = expenseRepository.findAll();
		for (ExpenseEntity expense : expenses) {
			Expense exp = new Expense(expense.getId(), expense.getReason(), expense.getDate(), expense.getVat(),
					String.valueOf(expense.getAmount()));
			list.add(exp);
		}
		return list;
	}

	@Override
	public void save(Expense expense) {
		ExpenseEntity entity = new ExpenseEntity(expense, CalculationUtils.calculateAmount(expense),
				CalculationUtils.calculateVat(expense, configuration.getVat()));
		expenseRepository.save(entity);
	}

}
