package com.dev.listi.domain.vo;



import com.dev.listi.exceptions.EmailNotValidException;

import java.util.Objects;

public class Email {


    private String email;

    private final String REGEX_EMAIL_VALID = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

    public Email(String email) {
        if(Objects.isNull(email)) {
            throw new EmailNotValidException("Email cannot be null");
        }
        if(!isValidEmail(email)) {
            throw new EmailNotValidException("Email is not valid: " + email);
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


    private boolean isValidEmail(String email) {
        if(email.isBlank() || email.isEmpty() || !email.matches(REGEX_EMAIL_VALID)) {
            return false;
        }



        return true;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                '}';
    }

}