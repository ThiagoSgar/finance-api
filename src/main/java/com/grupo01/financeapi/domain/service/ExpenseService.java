package com.grupo01.financeapi.domain.service;

import com.grupo01.financeapi.api.dto.ExpenseDTO;
import com.grupo01.financeapi.domain.model.Expense;
import com.grupo01.financeapi.domain.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository repository;

    public ResponseEntity<ExpenseDTO> create(Expense expense) {
        return new ResponseEntity<>(repository.save(expense).toDto(), HttpStatus.CREATED);
    }

}
