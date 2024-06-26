package com.dev.listi.app.usecases.impl;


import com.dev.listi.app.dto.AccountRecord;
import com.dev.listi.app.usecases.CreateAccount;
import com.dev.listi.domain.entities.Account;
import com.dev.listi.domain.repository.AccountRepository;
import com.dev.listi.infra.db.h2.mapper.AccountMapper;
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
