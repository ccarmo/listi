package com.dev.listi.app.usecases.impl;


import com.dev.listi.app.dto.TransactionRecord;
import com.dev.listi.app.usecases.ListTransactions;
import com.dev.listi.domain.entities.Transaction;
import com.dev.listi.infra.db.h2.mapper.TransactionMapper;
import com.dev.listi.infra.db.h2.repository.TransactionRepositoryH2;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ListTransactionsImpl implements ListTransactions {

    @Inject
    TransactionMapper transactionMapper;

    @Inject
    TransactionRepositoryH2 transactionRepositoryH2;

    @Override
    public List<TransactionRecord> transactionsList(String accountNumber) {
        List<Transaction> transactionlList = transactionRepositoryH2.listTransaction(accountNumber);
        List<TransactionRecord> transactionRecordList =  new ArrayList<>();
        for(Transaction transaction: transactionlList) {
            transactionRecordList.add(transactionMapper.transactionToTransactionRecord(transaction));
        }
        return transactionRecordList;
    }
}
