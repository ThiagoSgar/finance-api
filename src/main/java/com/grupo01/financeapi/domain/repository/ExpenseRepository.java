package com.grupo01.financeapi.domain.repository;

import com.grupo01.financeapi.domain.model.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
}
