package com.fin.budget.tracking.transaction.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransaction {
    private Long id;
    private LocalDateTime dateTime;
    private Long amount;
    private String description;
    private Long subCategory;
    private Long accountId;
    private AccountTransactionStatus status;
}
