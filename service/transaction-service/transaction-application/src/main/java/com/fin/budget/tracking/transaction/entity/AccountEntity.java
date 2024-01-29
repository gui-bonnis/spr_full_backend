package com.fin.budget.tracking.transaction.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Builder
@ToString
@Table("accounts")
public class AccountEntity {
    @Id
    private Long id;
    private Long balance;
    private String name;
}
