package com.dev.listi.domain.entities;

public enum TypeTransaction {
    CREDIT,
    DEPOSIT,
    TRANSFER;

    public static TypeTransaction of(String value) {
        for (TypeTransaction type: TypeTransaction.values()) {
            if(type.toString().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No constant with text " + value + " found");
    }
}
