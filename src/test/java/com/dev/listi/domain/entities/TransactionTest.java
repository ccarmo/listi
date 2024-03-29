package com.dev.listi.domain.entities;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    void transactionBuilderCreatesTransactionWithCorrectValues() {
        BigDecimal value = BigDecimal.valueOf(100);
        String idAccount = "123456789";
        String typeTransaction = "deposit";

        Transaction transaction = new Transaction.Builder()
                .value(value)
                .idAccount(idAccount)
                .typeTransaction(typeTransaction)
                .create();

        assertNotNull(transaction.getIdTransaction());
        assertEquals(value, transaction.getValue());
        assertEquals(idAccount, transaction.getIdAccount());
        assertEquals(typeTransaction, transaction.getTypeTransaction());
        assertNotNull(transaction.getDateTransaction());
    }

    @Test
    void transactionHasUniqueId() {
        Transaction transaction1 = new Transaction.Builder().create();
        Transaction transaction2 = new Transaction.Builder().create();

        assertNotEquals(transaction1.getIdTransaction(), transaction2.getIdTransaction());
    }
}
