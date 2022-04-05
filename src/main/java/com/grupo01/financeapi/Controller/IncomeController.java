package com.grupo01.financeapi.Controller;

import com.grupo01.financeapi.Model.Dto.IncomeDTO;
import com.grupo01.financeapi.Model.Income;
import com.grupo01.financeapi.Service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping("/id")
    public ResponseEntity<IncomeDTO> listById(@PathVariable Long id){
        return incomeService.listById(id);
    }
    @PutMapping("/id")
    public ResponseEntity<IncomeDTO> update(@PathVariable Long id, @RequestBody @Valid Income income){
        return incomeService.update(id, income);
    }

}
