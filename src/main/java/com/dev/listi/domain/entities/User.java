package com.dev.listi.domain.entities;


import com.dev.listi.domain.vo.Email;


import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {


    private String idUser;
    private String name;

    private Email email;

    /**
     private Address address;

     **/

    public User (String name, Email email) {
        this.idUser   = UUID.randomUUID().toString();
        this.name     = name;
        this.email    = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }
    public String getIdUser() {
        return this.idUser;
    }

    public Email getEmail() { return this.email; }


}