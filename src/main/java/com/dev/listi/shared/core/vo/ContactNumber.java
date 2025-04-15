package com.dev.listi.shared.core.vo;

public class ContactNumber {


    private String contactNumber;

    public ContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    private void isValidContactNumber(String contactNumber) {
        // TODO: Implementar validação do número de telefone
    }
}