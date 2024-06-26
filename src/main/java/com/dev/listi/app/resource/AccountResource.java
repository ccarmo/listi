package com.dev.listi.app.resource;

import com.dev.listi.app.dto.AccountRecord;
import com.dev.listi.app.services.AccountService;
import com.dev.listi.app.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/accounts")
public class AccountResource {

    @Inject
    AccountService accountService;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response createAccount(AccountRecord account) {
        return accountService.createAccount(account);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("email") String email) {
        return accountService.getAccount(email);
    }

}
