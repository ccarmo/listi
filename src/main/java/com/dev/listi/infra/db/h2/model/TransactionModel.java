package com.dev.listi.infra.db.h2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class TransactionModel {

    private static final String TABLE_NAME_TRANSACTIONS = "transactions";
    @Id
    private String idTransaction;
    private BigDecimal valueTransaction;

    private String accountNumber;

    private String typeTransaction;

    private String dateTransaction;

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public BigDecimal getValueTransaction() {
        return valueTransaction;
    }

    public void setValueTransaction(BigDecimal valueTransaction) {
        this.valueTransaction = valueTransaction;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    @Override
    public String toString() {
        return "TransactionModel{" +
                "idTransaction='" + idTransaction + '\'' +
                ", valueTransaction=" + valueTransaction +
                ", accountNumber='" + accountNumber + '\'' +
                ", typeTransaction='" + typeTransaction + '\'' +
                ", dateTransaction='" + dateTransaction + '\'' +
                '}';
    }
}
