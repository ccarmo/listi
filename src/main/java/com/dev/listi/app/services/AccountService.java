package com.dev.listi.app.services;

import com.dev.listi.app.dto.AccountRecord;

import com.dev.listi.app.usecases.impl.CreateAccountImpl;

import com.dev.listi.app.usecases.impl.GetAccountImpl;
import com.dev.listi.domain.exceptions.AccountNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@ApplicationScoped
public class AccountService {

    @Inject
    GetAccountImpl getAccountImpl;

    @Inject
    CreateAccountImpl createAccountImpl;


    public Response createAccount(AccountRecord account) {
        Optional<AccountRecord> accountRecord = createAccountImpl.createAccount(account);
        return Response.ok(accountRecord.get()).build();
    }

    public Response getAccount(String accountNumber) {
        try {
            Optional<AccountRecord> accountRecord = this.getAccountImpl.getAccount(accountNumber);
            return Response.ok(accountRecord.get()).build();
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
