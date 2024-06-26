package com.dev.listi.domain.repository;


import com.dev.listi.domain.entities.Transaction;

import java.util.List;

public interface TransactionRepository {

    void savedTransaction(Transaction transaction);

    List<Transaction> listTransaction(String accountNumber);
}
