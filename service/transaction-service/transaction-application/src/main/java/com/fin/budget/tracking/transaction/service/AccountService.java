package com.fin.budget.tracking.transaction.service;

import com.fin.budget.tracking.transaction.dto.response.CreateAccountResponse;
import com.fin.budget.tracking.transaction.dto.response.UpdateAccountResponse;
import com.fin.budget.tracking.transaction.model.Account;
import com.fin.budget.tracking.transaction.repository.AccountRepository;
import com.fin.budget.tracking.transaction.util.EntityDtoUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Mono<Account> getById(final Long id) {
        return repository.findById(id)
                .map(EntityDtoUtil::toAccount);
    }

    public ResponseEntity<Account> describeById(final Long id) {
        return null;
    }

    public Flux<Account> getAll() {
        return repository.findAll()
                .map(EntityDtoUtil::toAccount);
    }

    public Mono<CreateAccountResponse> create(final Mono<Account> accountMono) {
        return accountMono
                .map(EntityDtoUtil::toAccountEntity)
                .flatMap(repository::save)
                .map(EntityDtoUtil::toCreateAccountResponse);
    }

    public Mono<UpdateAccountResponse> updateById(final Long id, final Mono<Account> accountMono) {
        return repository.findById(id)
                                .flatMap(a -> accountMono
                                                    .map(EntityDtoUtil::toAccountEntity)
                                                    .doOnNext(e -> e.setId(id))
                                )
                                .flatMap(repository::save)
                                .map(EntityDtoUtil::toUpdateAccountResponse);
    }

    public Mono<UpdateAccountResponse> partialUpdateById(final Long id, final Mono<Account> accountMono) {
        return repository.findById(id)
                .flatMap(a -> accountMono
                        .map(tmp -> {
                            if (!tmp.getName().isBlank())
                                a.setName(tmp.getName());
                            return a;
                        })
                        .doOnNext(e -> e.setId(id))
                )
                .flatMap(repository::save)
                .map(EntityDtoUtil::toUpdateAccountResponse);
    }

    public Mono<Void> deleteById(final Long id) {
        return repository.deleteById(id);
    }

}
