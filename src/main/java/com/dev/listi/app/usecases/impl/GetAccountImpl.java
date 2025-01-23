package com.dev.listi.app.usecases.impl;



import com.dev.listi.usermanagement.exceptions.AccountNotFoundException;
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
