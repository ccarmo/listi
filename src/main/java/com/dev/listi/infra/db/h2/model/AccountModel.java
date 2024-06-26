package com.dev.listi.infra.db.h2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class AccountModel {

    private static final String TABLE_NAME_ACCOUNT = "accounts";

    @Id
    private String idAccount;
    private String idUser;

    private String accountNumber;

    private String numberAgency;

    private  BigDecimal limitAccount;

    private String typeAccount;

    private BigDecimal balance;

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getNumberAgency() {
        return numberAgency;
    }

    public void setNumberAgency(String numberAgency) {
        this.numberAgency = numberAgency;
    }

    public BigDecimal getLimitAccount() {
        return limitAccount;
    }

    public void setLimitAccount(BigDecimal limitAccount) {
        this.limitAccount = limitAccount;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}