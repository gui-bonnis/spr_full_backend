package com.fin.budget.tracking.transaction.dto.response;

import lombok.Builder;

@Builder
public record UpdateAccountResponse(Long id, String name, Long balance) {
}
