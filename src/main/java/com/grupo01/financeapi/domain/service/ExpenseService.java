package com.grupo01.financeapi.domain.service;

import com.grupo01.financeapi.api.dto.ExpenseDTO;
import com.grupo01.financeapi.domain.model.Expense;
import com.grupo01.financeapi.domain.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {


    @Autowired
    ExpenseRepository repository;


    public List<ExpenseDTO> listAll() {
        List<ExpenseDTO> expenseDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(expense -> expenseDTOList.add(expense.toDto()));
        return expenseDTOList;
    }

    public ResponseEntity<ExpenseDTO> listById(Long id) {
        return repository.findById(id)
                .map(expense -> ResponseEntity.ok().body(expense.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ExpenseDTO> create(Expense expense) {
        return new ResponseEntity<>(repository.save(expense).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Expense> expense = repository.findById(id);
        if (expense.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}