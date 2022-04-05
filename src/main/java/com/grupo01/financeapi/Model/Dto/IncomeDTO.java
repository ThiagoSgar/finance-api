package com.grupo01.financeapi.Model.Dto;

import com.grupo01.financeapi.Model.Income;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class IncomeDTO {

    private String description;
    private BigDecimal value;
    private LocalDate date;

    public IncomeDTO(Income income) {
        this.description = income.getDescription();
        this.value = income.getValue();
        this.date = income.getDate();
    }
}
