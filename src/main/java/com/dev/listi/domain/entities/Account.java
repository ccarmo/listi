package com.dev.listi.domain.entities;


import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Account {

    private String idAccount;
    private String idUser;

    private String accountNumber;

    private String numberAgency;

    private  BigDecimal limitAccount;

    private TypeAccount typeAccount;

    private BigDecimal balance;

    public Account(TypeAccount typeAccount, String idUser) {
        StringBuilder stringBuilder = new StringBuilder().append(idUser).append(typeAccount);

        this.idAccount   = UUID.randomUUID().toString();
        this.idUser = idUser;
        this.accountNumber = this.createNumberAccount(stringBuilder.toString()).get();
        this.numberAgency = "0001";
        this.limitAccount = BigDecimal.valueOf(100);
        this.typeAccount = typeAccount;
        this.balance = BigDecimal.ZERO;
    }

    private Optional<String> createNumberAccount(String identifier) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(identifier.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                Integer value = Math.abs(b % 10);
                sb.append(value);
            }

            return Optional.of(sb.toString().substring(0, 5));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

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

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
        return Objects.hash(idAccount, idUser, accountNumber, numberAgency, limitAccount, typeAccount, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount='" + idAccount + '\'' +
                ", idUser='" + idUser + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", numberAgency='" + numberAgency + '\'' +
                ", limitAccount=" + limitAccount +
                ", typeAccount=" + typeAccount +
                ", balance=" + balance +
                '}';
    }
}