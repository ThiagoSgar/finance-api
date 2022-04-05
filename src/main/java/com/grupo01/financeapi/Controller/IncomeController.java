package com.grupo01.financeapi.Controller;

import com.grupo01.financeapi.Model.Dto.IncomeDTO;
import com.grupo01.financeapi.Model.Income;
import com.grupo01.financeapi.Service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
