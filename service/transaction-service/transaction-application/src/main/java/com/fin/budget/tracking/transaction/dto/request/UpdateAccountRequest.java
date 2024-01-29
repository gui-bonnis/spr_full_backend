package com.fin.budget.tracking.transaction.dto.request;

import lombok.Builder;

@Builder
public record UpdateAccountRequest(String name, Long balance) {
}
