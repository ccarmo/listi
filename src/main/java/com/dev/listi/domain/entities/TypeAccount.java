package com.dev.listi.domain.entities;

public enum TypeAccount {
    CURRENT_ACCOUNT;

    public static TypeAccount of(String value) {
        for (TypeAccount type: TypeAccount.values()) {
            if(type.toString().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No constant with text " + value + " found");
    }
}
