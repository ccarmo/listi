package com.dev.listi.domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        String idUser = UUID.randomUUID().toString();
        account = new Account("1234567890", BigDecimal.valueOf(1000), idUser);
    }

    @Test
    public void testGetters() {
        String idUser = account.getIdUser();
        String idAccount = account.getIdAccount();
        String accountNumber = account.getAccountNumber();
        BigDecimal balance = account.getBalance();

        assertEquals(account.getIdUser(), idUser);
        assertEquals(account.getIdAccount(), idAccount);
        assertEquals(account.getAccountNumber(), accountNumber);
        assertEquals(account.getBalance(), balance);
    }

    @Test
    public void testSetters() {
        account.setAccountNumber("0987654321");
        account.setBalance(BigDecimal.valueOf(2000));

        assertEquals("0987654321", account.getAccountNumber());
        assertEquals(BigDecimal.valueOf(2000), account.getBalance());
    }

    @Test
    public void testEqualsAndHashCode() {
        Account sameAccount = new Account(account.getAccountNumber(), account.getBalance(), account.getIdUser());
        Account differentAccount = new Account("0987654321", BigDecimal.valueOf(2000), UUID.randomUUID().toString());


        assertNotEquals(account, differentAccount);
        assertNotEquals(account.hashCode(), differentAccount.hashCode());
    }
}
