package com.dev.listi.domain.entities;

import java.util.UUID;

public class Statement {

    private String idStatement;

    private Transaction transaction;

    public Statement(Transaction transaction) {
        this.idStatement = UUID.randomUUID().toString();
        this.transaction = transaction;
    }

    public String getIdStatement() {
        return idStatement;
    }

    public void setIdStatement(String idStatement) {
        this.idStatement = idStatement;
    }

    public Transaction getPayment() {
        return transaction;
    }

    public void setPayment(Transaction transaction) {
        this.transaction = transaction;
    }
}
