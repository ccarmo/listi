package com.dev.listi.app.usecases.impl;


import com.dev.listi.app.dto.TransactionRecord;
import com.dev.listi.app.usecases.StartTransaction;
import com.dev.listi.domain.entities.Transaction;
import com.dev.listi.domain.repository.AccountRepository;
import com.dev.listi.domain.repository.TransactionRepository;
import com.dev.listi.infra.db.h2.mapper.TransactionMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.dev.listi.domain.entities.Account;


import java.math.BigDecimal;
import java.util.Optional;

@ApplicationScoped
public class StartTransactionImpl implements StartTransaction {

    @Inject
    TransactionRepository transactionRepository;

    @Inject
    AccountRepository accountRepository;

    @Inject
    TransactionMapper transactionMapper;

    @Override
    public TransactionRecord createTransaction(Transaction transaction) {
        Optional<Account> account = accountRepository.getAccountNumber(transaction.getAccountNumber());
        BigDecimal actualBalanceAccount = account.get().getBalance();
        BigDecimal newBalance = actualBalanceAccount.subtract(transaction.getValueTransaction());
        account.get().setBalance(newBalance);
        accountRepository.updatedAccount(account.get());
        transactionRepository.savedTransaction(transaction);
        TransactionRecord transactionRecord = transactionMapper.transactionToTransactionRecord(transaction);
        return transactionRecord;
    }


}
