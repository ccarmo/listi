package com.dev.listi.domain.entities;


import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Account {

    private String idAccount;
    private String idUser;

    private String accountNumber;

    private BigDecimal balance;

    public Account(String accountNumber, BigDecimal balance, String idUser) {
        this.idAccount   = UUID.randomUUID().toString();
        this.idUser = idUser;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getIdUser() {
        return this.idUser;
    }
    public String getIdAccount() {
        return this.idAccount;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(idAccount, account.idAccount) && Objects.equals(idUser, account.idUser) && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, idUser, accountNumber, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount='" + idAccount + '\'' +
                ", idUser='" + idUser + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
