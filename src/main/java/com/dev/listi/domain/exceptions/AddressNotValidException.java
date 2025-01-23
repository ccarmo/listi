package com.dev.listi.domain.exceptions;

public class AddressNotValidException extends RuntimeException {

    public AddressNotValidException(String message) {
        super(message);
    }

}
