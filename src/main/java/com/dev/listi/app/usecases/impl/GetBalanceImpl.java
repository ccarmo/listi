package com.dev.listi.app.usecases.impl;



import com.dev.listi.usermanagement.exceptions.AccountNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;



import java.math.BigDecimal;
import java.util.Optional;

@ApplicationScoped
public class GetBalanceImpl implements GetBalance {

    @Inject
    AccountRepository accountRepository;

    @Override
    public BigDecimal getBalance(String accountNumber) {
        Optional<Account> account = accountRepository.getAccountNumber(accountNumber);
        if(account.isEmpty()) {
            throw new AccountNotFoundException("Account not found for number: " + accountNumber);
        } else {
            return account.get().getBalance();
        }
    }
}
