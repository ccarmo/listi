package com.dev.listi.domain;


import com.dev.listi.domain.entities.Account;
import com.dev.listi.domain.entities.TypeAccount;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountTest {
    @Test
    void testCreateAccount() {
        String numberAgency = "0001";
        BigDecimal limitAccount = BigDecimal.valueOf(1000);
        BigDecimal balance = BigDecimal.ZERO;
        TypeAccount typeAccount = TypeAccount.CURRENT_ACCOUNT;
        String idUser = "user123";

        Account account = new Account(typeAccount, idUser);

        assertNotNull(account);
        assertEquals(numberAgency, account.getNumberAgency());
        assertEquals(idUser, account.getIdUser());
        assertNotNull(account.getIdAccount());
        assertNotNull(account.getAccountNumber());
        System.out.println(account.getAccountNumber());
        assertEquals(balance, account.getBalance());
        assertEquals(typeAccount, account.getTypeAccount());
    }
}
