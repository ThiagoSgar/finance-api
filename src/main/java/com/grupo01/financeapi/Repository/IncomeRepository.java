package com.grupo01.financeapi.Repository;

import com.grupo01.financeapi.Model.Income;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncomeRepository extends CrudRepository<Income, Long> {
    List<Income> findAll();
}
