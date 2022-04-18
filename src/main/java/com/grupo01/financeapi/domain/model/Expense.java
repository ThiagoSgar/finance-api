package com.grupo01.financeapi.domain.model;

import com.grupo01.financeapi.api.dto.ExpenseDTO;
import com.grupo01.financeapi.api.dto.IncomeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_expenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal value;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Category category;

    public ExpenseDTO toDto() {
        return new ExpenseDTO(this);
    }
}
