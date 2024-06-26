package com.dev.listi.domain.entities;

public class Statement {

    private String idStatement;

    private Transaction transaction;

    public Statement(Transaction transaction) {
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
