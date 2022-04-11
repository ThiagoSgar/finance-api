package com.grupo01.financeapi.api.controller;

import com.grupo01.financeapi.api.dto.ExpenseDTO;
import com.grupo01.financeapi.domain.model.Expense;
import com.grupo01.financeapi.domain.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService service;

    @PostMapping("/new")
    public ResponseEntity<ExpenseDTO> create(@RequestBody Expense expense) {
        return service.create(expense);
    }
}
