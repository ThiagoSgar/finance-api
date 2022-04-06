package com.grupo01.financeapi.api.dto;

import com.grupo01.financeapi.domain.model.Expense;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ExpenseDTO {
    private String description;
    private BigDecimal value;
    private LocalDate date;

    public ExpenseDTO(Expense expense) {
        this.description = expense.getDescription();
        this.value = expense.getValue();
        this.date = expense.getDate();
    }
}
