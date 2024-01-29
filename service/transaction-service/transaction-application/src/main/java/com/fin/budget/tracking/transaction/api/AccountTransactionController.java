package com.fin.budget.tracking.transaction.api;

import com.fin.budget.tracking.transaction.dto.request.CreateTransactionRequest;
import com.fin.budget.tracking.transaction.dto.request.UpdateTransactionRequest;
import com.fin.budget.tracking.transaction.dto.response.CreateTransactionResponse;
import com.fin.budget.tracking.transaction.dto.response.UpdateTransactionResponse;
import com.fin.budget.tracking.transaction.model.AccountTransaction;
import com.fin.budget.tracking.transaction.service.AccountTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("account/transaction")
public class AccountTransactionController {

    private final AccountTransactionService accountTransactionService;

    public AccountTransactionController(AccountTransactionService accountTransactionService) {
        this.accountTransactionService = accountTransactionService;
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<AccountTransaction>> getById(@PathVariable final Long id) {
        return this.accountTransactionService.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("{id}/describe")
    public Mono<ResponseEntity<AccountTransaction>> describeById(@PathVariable final Long id) {
        return this.accountTransactionService.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("all")
    public Flux<AccountTransaction> getAll() {
        return this.accountTransactionService.getAll();
    }

    @PostMapping
    public Mono<ResponseEntity<CreateTransactionResponse>> create(@RequestBody final Mono<CreateTransactionRequest> request) {
        var transaction = request.map(r -> AccountTransaction.builder()
                .accountId(r.accountId())
                .dateTime(r.dateTime())
                .description(r.description())
                .amount(r.amount())
                .subCategory(r.subCategory())
                .build());
        return this.accountTransactionService.create(transaction)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<UpdateTransactionResponse>> updateById(@PathVariable final Long id, @RequestBody final Mono<UpdateTransactionRequest> request) {
        var transaction = request.map(r -> AccountTransaction.builder()
                .description(r.description())
                .status(r.status())
                .build());
        return this.accountTransactionService.updateById(id, transaction)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    public Mono<ResponseEntity<UpdateTransactionResponse>> partialUpdateById(@PathVariable final Long id, @RequestBody final Mono<UpdateTransactionRequest> request) {
        var transaction = request.map(r -> AccountTransaction.builder()
                .description(r.description())
                .status(r.status())
                .build());
        return this.accountTransactionService.updateById(id, transaction)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable final Long id) {
        return this.accountTransactionService.deleteById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
