package com.grupo01.financeapi.domain.model;

import com.grupo01.financeapi.api.dto.IncomeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_incomes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal value;

    @NotNull
    private LocalDate date;

    public IncomeDTO toDto() {
        return new IncomeDTO(this);
    }
}
