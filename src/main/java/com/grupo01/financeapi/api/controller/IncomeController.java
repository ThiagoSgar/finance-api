package com.grupo01.financeapi.api.controller;

import com.grupo01.financeapi.api.dto.IncomeDTO;
import com.grupo01.financeapi.domain.model.Income;
import com.grupo01.financeapi.domain.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    IncomeService service;

    @GetMapping
    public List<IncomeDTO> listAll() {
        return service.listAll();
    }

    @PostMapping("/new")
    public ResponseEntity<IncomeDTO> create(@RequestBody Income income) {
        return service.create(income);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<IncomeDTO> update(@PathVariable Long id, @RequestBody @Valid Income income){
        return service.update(id, income);
    }

}

