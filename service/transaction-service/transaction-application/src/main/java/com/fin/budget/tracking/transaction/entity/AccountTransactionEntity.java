package com.fin.budget.tracking.transaction.entity;

import com.fin.budget.tracking.transaction.model.AccountTransactionStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("account_transaction")
public class AccountTransactionEntity {
    @Id
    private Long id;
    private LocalDateTime dateTime;
    private Long amount;
    private String description;
    private Long subCategory;
    private Long accountId;
    private AccountTransactionStatus status;
    private LocalDateTime transactionDate;
}
