package com.dev.listi.app.usecases.impl;

import com.dev.listi.app.usecases.CreateAccountUseCase;
import com.dev.listi.domain.entities.Account;
import com.dev.listi.infra.db.h2.repository.AccountRepositoryH2;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class CreateAccountUseCaseImpl implements CreateAccountUseCase {

    @Inject
    AccountRepositoryH2 accountRepositoryH2;

    @Override
    public Optional<Account> createAccount(Account account) {
        return accountRepositoryH2.createAccount(account);
    }
}
