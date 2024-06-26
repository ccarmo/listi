package com.dev.listi.app.usecases;

import com.dev.listi.app.dto.TransactionRecord;
import com.dev.listi.domain.entities.Transaction;

public interface StartTransaction {

    TransactionRecord createTransaction(Transaction transaction);
}
