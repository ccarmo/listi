package com.dev.listi.domain.vo;


import com.dev.listi.domain.vo.Email;
import com.dev.listi.exceptions.EmailNotValidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {

    @Test
    public void testValidEmail() {
        String validEmail = "example@example.com";
        Email email = new Email(validEmail);
        assertEquals(validEmail, email.getEmail());
    }

    @Test
    public void testInvalidEmail() {
        String invalidEmail = "invalidemail";
        assertThrows(EmailNotValidException.class, () -> new Email(invalidEmail));
    }

    @Test
    public void testNullEmail() {
        assertThrows(EmailNotValidException.class, () -> new Email(null));
    }

    @Test
    public void testEmptyEmail() {
        assertThrows(EmailNotValidException.class, () -> new Email(""));
    }

    @Test
    public void testBlankEmail() {
        assertThrows(EmailNotValidException.class, () -> new Email("   "));
    }

    @Test
    public void testEqualsAndHashCode() {
        String emailStr1 = "example@example.com";
        String emailStr2 = "example@example.com";
        Email email1 = new Email(emailStr1);
        Email email2 = new Email(emailStr2);

        assertEquals(email1, email2);
        assertEquals(email1.hashCode(), email2.hashCode());
    }

}
