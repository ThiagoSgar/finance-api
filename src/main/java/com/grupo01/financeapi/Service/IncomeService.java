package com.grupo01.financeapi.Service;

import com.grupo01.financeapi.Model.Dto.IncomeDTO;
import com.grupo01.financeapi.Model.Income;
import com.grupo01.financeapi.Repository.IncomeRepository;
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

    public ResponseEntity<IncomeDTO> create(Income income) {
        return new ResponseEntity<>(repository.save(income).toDto(), HttpStatus.CREATED);
    }
}
