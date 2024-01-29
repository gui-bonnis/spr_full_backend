package com.fin.budget.tracking.transaction.dto.response;

import com.fin.budget.tracking.transaction.model.AccountTransactionStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CreateTransactionResponse(Long id, LocalDateTime dateTime, Long amount, String description, Long subCategory,
                                        Long accountId, AccountTransactionStatus status) {
}