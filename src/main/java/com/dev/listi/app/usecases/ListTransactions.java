package com.dev.listi.app.usecases;


import com.dev.listi.app.dto.TransactionRecord;

import java.util.List;

public interface ListTransactions {

    List<TransactionRecord> transactionsList(String accountNumber);
}
