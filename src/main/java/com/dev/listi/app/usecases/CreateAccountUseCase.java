package com.dev.listi.app.usecases;

import com.dev.listi.domain.entities.Account;


import java.util.Optional;

public interface CreateAccountUseCase {

    Optional<Account> createAccount(Account account);
}
