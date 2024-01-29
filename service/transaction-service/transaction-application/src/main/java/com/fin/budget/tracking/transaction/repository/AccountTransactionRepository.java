package com.fin.budget.tracking.transaction.repository;

import com.fin.budget.tracking.transaction.entity.AccountTransactionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountTransactionRepository extends ReactiveCrudRepository<AccountTransactionEntity, Long> {

}
