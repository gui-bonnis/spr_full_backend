package com.fin.budget.tracking.transaction.util;

import com.fin.budget.tracking.transaction.dto.response.CreateAccountResponse;
import com.fin.budget.tracking.transaction.dto.response.CreateTransactionResponse;
import com.fin.budget.tracking.transaction.dto.response.UpdateAccountResponse;
import com.fin.budget.tracking.transaction.dto.response.UpdateTransactionResponse;
import com.fin.budget.tracking.transaction.entity.AccountEntity;
import com.fin.budget.tracking.transaction.entity.AccountTransactionEntity;
import com.fin.budget.tracking.transaction.model.Account;
import com.fin.budget.tracking.transaction.model.AccountTransaction;

import java.time.LocalDateTime;

public class EntityDtoUtil {

    public static Account toAccount(final AccountEntity entity) {
        return Account.builder()
                .id(entity.getId())
                .balance(entity.getBalance())
                .name(entity.getName())
                .build();
    }

    public static AccountEntity toAccountEntity(final Account account) {
        return AccountEntity.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .name(account.getName())
                .build();
    }

    public static CreateAccountResponse toCreateAccountResponse(final AccountEntity account) {
        return CreateAccountResponse.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .name(account.getName())
                .build();
    }

    public static UpdateAccountResponse toUpdateAccountResponse(final AccountEntity account) {
        return UpdateAccountResponse.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance())
                .build();
    }



    public static AccountTransaction toTransaction(final AccountTransactionEntity entity) {
        return AccountTransaction.builder()
                .id(entity.getId())
                .dateTime(entity.getDateTime())
                .description(entity.getDescription())
                .amount(entity.getAmount())
                .accountId(entity.getAccountId())
                .status(entity.getStatus())
                .build();
    }

    public static AccountTransactionEntity toAccountTransactionEntity(final AccountTransaction accountTransaction) {
        return AccountTransactionEntity.builder()
                .id(accountTransaction.getId())
                .dateTime(accountTransaction.getDateTime())
                .description(accountTransaction.getDescription())
                .amount(accountTransaction.getAmount())
                .accountId(accountTransaction.getAccountId())
                .status(accountTransaction.getStatus())
                .transactionDate(LocalDateTime.now())
                .build();
    }

    public static CreateTransactionResponse toCreateTransactionResponse(final AccountTransactionEntity transaction) {
        return CreateTransactionResponse.builder()
                .id(transaction.getId())
                .dateTime(transaction.getDateTime())
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .accountId(transaction.getAccountId())
                .status(transaction.getStatus())
                .build();
    }

    public static UpdateTransactionResponse toUpdateTransactionResponse(final AccountTransactionEntity transaction) {
        return UpdateTransactionResponse.builder()
                .id(transaction.getId())
                .dateTime(transaction.getDateTime())
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .accountId(transaction.getAccountId())
                .status(transaction.getStatus())
                .build();
    }
}
