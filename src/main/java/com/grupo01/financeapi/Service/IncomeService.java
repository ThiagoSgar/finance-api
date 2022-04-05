package com.grupo01.financeapi.Service;

import com.grupo01.financeapi.Model.Dto.IncomeDTO;
import com.grupo01.financeapi.Model.Income;
import com.grupo01.financeapi.Repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public ResponseEntity<IncomeDTO> listById(Long id) {
        return incomeRepository.findById(id)
                .map(income -> ResponseEntity.ok().body(income.toDto())).orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<IncomeDTO> update(Long id, Income income){
        return incomeRepository.findById(id)
                .map(updated -> {
                    updated.setId(income.getId());
                    updated = incomeRepository.save(income);
                    return ResponseEntity.ok(updated.toDto());
                }).orElse(ResponseEntity.notFound().build());
    }
}
