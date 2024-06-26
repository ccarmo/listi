package com.dev.listi.infra.db.h2.repository;


import com.dev.listi.domain.entities.Transaction;
import com.dev.listi.domain.repository.TransactionRepository;
import com.dev.listi.infra.db.h2.mapper.TransactionMapper;
import com.dev.listi.infra.db.h2.model.TransactionModel;
import com.dev.listi.infra.db.h2.repository.panache.TransactionRepositoryPanache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class TransactionRepositoryH2 implements TransactionRepository {

    @Inject
    TransactionMapper transactionMapper;
    @Inject
    TransactionRepositoryPanache transactionRepositoryPanache;
    @Override
    public void savedTransaction(Transaction transaction) {
        TransactionModel transactionModel = transactionMapper.transactionToTransactionModel(transaction);
        System.out.println(transactionModel.toString());
        transactionRepositoryPanache.persist(transactionModel);
    }

    @Override
    public List<Transaction> listTransaction(String accountNumber) {
        List<TransactionModel> transactionModelList = transactionRepositoryPanache.findAllByAccountNumber(accountNumber);
        List<Transaction> transactionList =  new ArrayList<>();

        for (TransactionModel transactionModel: transactionModelList) {
            Transaction transaction = transactionMapper.transactionModelToTransaction(transactionModel);
            transactionList.add(transaction);
        }
        return transactionList;
    }
}
