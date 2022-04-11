package com.grupo01.financeapi.domain.service;

import com.grupo01.financeapi.api.dto.IncomeDTO;
import com.grupo01.financeapi.domain.model.Income;
import com.grupo01.financeapi.domain.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository repository;

    public List<IncomeDTO> listAll() {
        List<IncomeDTO> incomeDTOList = new ArrayList<>();
        repository.findAll()
            .forEach(income -> incomeDTOList.add(income.toDto()));
        return incomeDTOList;
    }

    public ResponseEntity<IncomeDTO> listById(Long id) {
        return repository.findById(id)
                .map(income -> ResponseEntity.ok().body(income.toDto())).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<IncomeDTO> create(Income income) {
        return new ResponseEntity<>(repository.save(income).toDto(), HttpStatus.CREATED);
    }


    public ResponseEntity<IncomeDTO> update(Long id, Income income){
        return repository.findById(id)
                .map(updated -> {
                    updated.setId(income.getId());
                    updated = repository.save(income);
                    return ResponseEntity.ok(updated.toDto());
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> deleteById(Long incomeId) {
        return repository.findById(incomeId)
                .map(income -> {
            repository.delete(income);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.noContent().build());
    }
}
