package com.fin.budget.tracking.transaction.repository;

import com.fin.budget.tracking.transaction.entity.AccountEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<AccountEntity, Long> {
}
