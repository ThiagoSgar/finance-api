package com.grupo01.financeapi.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_incomes")
@Getter
@Setter
public class Income {

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
}
