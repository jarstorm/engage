package com.company.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.backend.bean.Expense;
import com.company.backend.service.ExpenseService;

@Controller
public class AppController {
	
	@Autowired
	private ExpenseService expenseService;
	
    @RequestMapping("/expenses")
    public @ResponseBody List<Expense> expenses(Model model) {
    	return expenseService.findAll();
    }

    @PostMapping("/expenses")
    public ResponseEntity<Expense> addExpense(Model model, @RequestBody Expense expense) {
    	expenseService.save(expense);
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
    }
}
