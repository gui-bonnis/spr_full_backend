package com.fin.budget.tracking.transaction.service;

import com.fin.budget.tracking.transaction.dto.response.CreateTransactionResponse;
import com.fin.budget.tracking.transaction.dto.response.UpdateTransactionResponse;
import com.fin.budget.tracking.transaction.model.AccountTransaction;
import com.fin.budget.tracking.transaction.repository.AccountTransactionRepository;
import com.fin.budget.tracking.transaction.util.EntityDtoUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountTransactionService {

    private final AccountTransactionRepository repository;

    public AccountTransactionService(AccountTransactionRepository repository) {
        this.repository = repository;
    }


    public Mono<AccountTransaction> getById(final Long id) {
        return repository.findById(id)
                .map(EntityDtoUtil::toTransaction);
    }

    public ResponseEntity<AccountTransaction> describeById(final Long id) {
        return null;
    }

    public Flux<AccountTransaction> getAll() {
        return repository.findAll()
                .map(EntityDtoUtil::toTransaction);
    }

    public Mono<CreateTransactionResponse> create(final Mono<AccountTransaction> transactionMono) {
        return transactionMono
                .map(EntityDtoUtil::toAccountTransactionEntity)
                .flatMap(repository::save)
                .map(EntityDtoUtil::toCreateTransactionResponse);
    }

    public Mono<UpdateTransactionResponse> updateById(final Long id, final Mono<AccountTransaction> transactionMono) {
        return repository.findById(id)
                .flatMap(a -> transactionMono
                        .map(EntityDtoUtil::toAccountTransactionEntity)
                        .doOnNext(e -> e.setId(id))
                )
                .flatMap(repository::save)
                .map(EntityDtoUtil::toUpdateTransactionResponse);
    }

    public Mono<UpdateTransactionResponse> partialUpdateById(final Long id, final Mono<AccountTransaction> transactionMono) {
        return repository.findById(id)
                .flatMap(a -> transactionMono
                        .map(tmp -> {
                            if (tmp.getAccountId() != null)
                                a.setAccountId(tmp.getAccountId());
                            if (!tmp.getDescription().isBlank())
                                a.setDescription(tmp.getDescription());
                            if (tmp.getAmount() != null)
                                a.setAmount(tmp.getAmount());
                            if (tmp.getDateTime() != null)
                                a.setDateTime(tmp.getDateTime());
                            if (tmp.getSubCategory() != null)
                                a.setSubCategory(tmp.getSubCategory());
                            if (tmp.getStatus() != null)
                                a.setStatus(tmp.getStatus());
                            return a;
                        })
                        .doOnNext(e -> e.setId(id))
                )
                .flatMap(repository::save)
                .map(EntityDtoUtil::toUpdateTransactionResponse);
    }

    public Mono<Void> deleteById(final Long id) {
        return repository.deleteById(id);
    }


}
