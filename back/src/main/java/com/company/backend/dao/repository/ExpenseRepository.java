package com.company.backend.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.company.backend.dao.bean.ExpenseEntity;

public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

}
