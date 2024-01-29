package com.fin.budget.tracking.transaction.api;

import com.fin.budget.tracking.transaction.dto.request.CreateAccountRequest;
import com.fin.budget.tracking.transaction.dto.request.UpdateAccountRequest;
import com.fin.budget.tracking.transaction.dto.response.CreateAccountResponse;
import com.fin.budget.tracking.transaction.dto.response.UpdateAccountResponse;
import com.fin.budget.tracking.transaction.model.Account;
import com.fin.budget.tracking.transaction.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Account>> getById(@PathVariable final Long id) {
        return this.accountService.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("{id}/describe")
    public Mono<ResponseEntity<Account>> describeById(@PathVariable final Long id) {
        return this.accountService.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("all")
    public Flux<Account> getAll() {
        return this.accountService.getAll();

    }

    @PostMapping
    public Mono<ResponseEntity<CreateAccountResponse>> create(@RequestBody final Mono<CreateAccountRequest> request) {
        var account = request.map(r -> Account.builder()
                .name(r.name())
                .balance(r.balance())
                .build());
        return this.accountService.create(account)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<UpdateAccountResponse>> updateById(@PathVariable final Long id, @RequestBody final Mono<UpdateAccountRequest> request) {
        var account = request.map(r -> Account.builder()
                .name(r.name())
                .balance(r.balance())
                .build());
        return this.accountService.updateById(id, account)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    public Mono<ResponseEntity<UpdateAccountResponse>> partialUpdateById(@PathVariable final Long id, @RequestBody final Mono<UpdateAccountRequest> request) {
        var account = request.map(r -> Account.builder()
                .name(r.name())
                .build());
        return this.accountService.updateById(id, account)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable final Long id) {
        return this.accountService.deleteById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
