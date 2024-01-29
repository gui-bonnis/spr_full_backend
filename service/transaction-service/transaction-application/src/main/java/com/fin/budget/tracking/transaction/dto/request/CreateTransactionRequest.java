package com.fin.budget.tracking.transaction.dto.request;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CreateTransactionRequest(LocalDateTime dateTime, Long amount, String description, Long subCategory,
                                       Long accountId) {
}
