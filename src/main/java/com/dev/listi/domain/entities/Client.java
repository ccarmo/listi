package com.dev.listi.domain.entities;

import com.dev.listi.domain.vo.Address;
import com.dev.listi.domain.vo.ContactNumber;
import com.dev.listi.domain.vo.Email;

public class Client {

    private String name;
    private String cpf;
    private Email email;
    private ContactNumber contactNumber;
    private Address address;



    public Client() {
    }

    public Client(String name, String cpf, Email email, ContactNumber contactNumber, Address address, User user) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;

    }

    public Client(String name, String email) {
        this.name = name;
        this.email = new Email(email);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ContactNumber contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email=" + email +
                ", contactNumber=" + contactNumber +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!name.equals(client.name)) return false;
        if (!cpf.equals(client.cpf)) return false;
        if (!email.equals(client.email)) return false;
        if (!contactNumber.equals(client.contactNumber)) return false;
        return address.equals(client.address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + contactNumber.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}

