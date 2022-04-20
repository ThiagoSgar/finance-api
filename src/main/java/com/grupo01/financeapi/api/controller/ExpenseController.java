package com.grupo01.financeapi.api.controller;

import com.grupo01.financeapi.api.dto.ExpenseDTO;
import com.grupo01.financeapi.domain.model.Expense;
import com.grupo01.financeapi.domain.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService service;

    @GetMapping
    public List<ExpenseDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @GetMapping(params = "description")
    public List<ExpenseDTO> listByDescription(@RequestParam String description){
        return service.listByDescription(description);
    }

    @PostMapping("/new")
    public ResponseEntity<ExpenseDTO> create(@RequestBody Expense expense) {
        return service.create(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
