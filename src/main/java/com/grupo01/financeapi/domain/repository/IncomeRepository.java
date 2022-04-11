package com.grupo01.financeapi.domain.repository;

import com.grupo01.financeapi.domain.model.Income;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncomeRepository extends CrudRepository<Income, Long> {
    List<Income> findAll();
    List<Income> findByDescription(String description);
}
