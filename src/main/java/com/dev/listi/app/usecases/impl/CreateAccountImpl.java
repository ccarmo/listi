package com.dev.listi.app.usecases.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


import java.util.Optional;

@ApplicationScoped
public class CreateAccountImpl implements CreateAccount {

    @Inject
    AccountRepository accountRepository;

    @Inject
    AccountMapper accountMapper;


    @Override
    public Optional<AccountRecord> createAccount(AccountRecord accountRecord) {
        Account account = new Account(accountRecord.typeAccount(),accountRecord.idUser());
        Optional<Account> accountCreated = accountRepository.createAccount(account);
        AccountRecord accountRecordMapepr = accountMapper.accountToAccountRecord(accountCreated.get());
        return Optional.of(accountRecordMapepr);
    }
}
