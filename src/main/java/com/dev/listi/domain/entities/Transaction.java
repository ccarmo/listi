package com.dev.listi.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class Transaction {

    private String idTransaction;
    private BigDecimal valueTransaction;


    private String accountNumber;

    private TypeTransaction typeTransaction;

    private String dateTransaction;




    private Transaction(TransactionBuilder transactionBuilder) {
        this.valueTransaction = transactionBuilder.value;
        this.accountNumber        = transactionBuilder.accountNumber;
        this.typeTransaction  = transactionBuilder.typeTransaction;
        if (transactionBuilder.dateTransaction != null) {
            this.dateTransaction = transactionBuilder.dateTransaction;
            this.idTransaction    = UUID.randomUUID().toString();
        }
    }

    public static TransactionBuilder builder() {
        return new TransactionBuilder();
    }

    public static class TransactionBuilder {
        private BigDecimal value;

        private String accountNumber;

        private TypeTransaction typeTransaction;
        private String dateTransaction;


        public TransactionBuilder value(BigDecimal value) {
            this.value = value;
            return this;
        }

        public TransactionBuilder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public TransactionBuilder typeTransaction(TypeTransaction typeTransaction) {
            this.typeTransaction = typeTransaction;
            return this;
        }

        public TransactionBuilder withCreationDate() {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            this.dateTransaction = localDateTime.format(formatter);
            return this;
        }



        public Transaction build() {
            return new Transaction(this);
        }

    }







    public String getIdTransaction() {
        return idTransaction;
    }

    public BigDecimal getValueTransaction() {
        return valueTransaction;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public String getDateTransaction() {return this.dateTransaction;}

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction='" + idTransaction + '\'' +
                ", valueTransaction=" + valueTransaction +
                ", accountNumber='" + accountNumber + '\'' +
                ", typeTransaction=" + typeTransaction +
                ", dateTransaction='" + dateTransaction + '\'' +
                '}';
    }
}
