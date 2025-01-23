package com.dev.listi.domain.exceptions;

public class EmailNotValidException extends RuntimeException {

    public EmailNotValidException(String message) {
        super(message);
    }
}
