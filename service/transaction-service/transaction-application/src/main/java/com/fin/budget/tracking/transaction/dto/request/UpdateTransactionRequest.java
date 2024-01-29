package com.fin.budget.tracking.transaction.dto.request;

import com.fin.budget.tracking.transaction.model.AccountTransactionStatus;
import lombok.Builder;

@Builder
public record UpdateTransactionRequest(String description, AccountTransactionStatus status) {
}
