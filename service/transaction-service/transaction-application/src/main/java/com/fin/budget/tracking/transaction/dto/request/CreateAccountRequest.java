package com.fin.budget.tracking.transaction.dto.request;

import lombok.Builder;

@Builder
public record CreateAccountRequest(String name, Long balance) {
}
