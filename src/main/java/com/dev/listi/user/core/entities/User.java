package com.dev.listi.user.core.entities;

import com.dev.listi.shared.core.vo.Email;
import com.dev.listi.shared.core.vo.ContactNumber;

import java.util.UUID;

public class User  {


    private String idUser;
    private String name;

    private Email email;
    private ContactNumber phone;



    /**
    private Address address;
     **/

    public User (String name, Email email, ContactNumber phone) {
        this.idUser   = UUID.randomUUID().toString();
        this.name     = name;
        this.email    = email;
        this.phone    = phone;
    }

    public String getName() {
        return this.name;
    }
    public String getIdUser() {
        return this.idUser;
    }
    public Email getEmail() {
        return email;
    }

    public ContactNumber getPhone() {
        return phone;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setPhone(ContactNumber phone) {
        this.phone = phone;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }
}