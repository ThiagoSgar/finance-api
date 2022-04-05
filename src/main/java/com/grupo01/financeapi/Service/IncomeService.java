package com.grupo01.financeapi.Service;

import com.grupo01.financeapi.Model.Income;
import com.grupo01.financeapi.Repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository repository;

    public List<Income> listAll() {
        return repository.findAll();
    }

    public ResponseEntity<Income> create(Income income) {
        return new ResponseEntity<>(repository.save(income), HttpStatus.CREATED);
    }
}
