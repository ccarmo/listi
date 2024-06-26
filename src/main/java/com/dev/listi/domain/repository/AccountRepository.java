package com.dev.listi.domain.repository;


import com.dev.listi.domain.entities.Account;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> getAccountNumber(String accountNumber);
    Optional<Account> updatedAccount(Account account);

    Optional<Account> createAccount(Account account);

}
