package com.dev.listi.app.usecases.impl;

import com.dev.listi.infra.db.repository.AccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class CreateAccountUseCaseImpl implements CreateAccountUseCase {

    @Inject
    AccountRepository accountRepository;

    @Override
    public Optional<Account> createAccount(Account account) {
        return accountRepository.createAccount(account);
    }
}
