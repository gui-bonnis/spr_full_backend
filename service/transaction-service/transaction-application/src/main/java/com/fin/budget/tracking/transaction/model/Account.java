package com.fin.budget.tracking.transaction.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String name;
    private Long balance;
}
