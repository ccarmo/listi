package com.dev.listi.app.usecases.impl;



import com.dev.listi.app.dto.AccountRecord;
import com.dev.listi.app.usecases.GetAccount;
import com.dev.listi.domain.entities.Account;
import com.dev.listi.domain.exceptions.AccountNotFoundException;
import com.dev.listi.domain.repository.AccountRepository;
import com.dev.listi.infra.db.h2.mapper.AccountMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


import java.util.Optional;

@ApplicationScoped
public class GetAccountImpl implements GetAccount {

    @Inject
    AccountRepository accountRepository;

    @Inject
    AccountMapper accountMapper;


    @Override
    public Optional<AccountRecord> getAccount(String idAccount) {
        Optional<Account> account = accountRepository.getAccountNumber(idAccount);

        if(account.isEmpty()) {
            throw new AccountNotFoundException("Account not found for number: " + idAccount);
        } else {
            AccountRecord accountRecord = accountMapper.accountToAccountRecord(account.get());
            return Optional.of(accountRecord);
        }
    }
}
