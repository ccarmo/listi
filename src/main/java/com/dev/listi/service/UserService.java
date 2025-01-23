package com.dev.listi.service;

import com.dev.listi.app.dto.UserRecord;
import com.dev.listi.app.usecases.impl.CreateUserImpl;
import com.dev.listi.app.usecases.impl.GetUserImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@ApplicationScoped
public class UserService {
    @Inject
    private GetUserImpl getUserImpl;

    @Inject
    private CreateUserImpl createUserImpl;

    public Response createUser(String name) {

        Optional<UserRecord> userRecord = createUserImpl.createUser(name);
        return Response.ok(userRecord.get()).build();
    }

    public Response getUser(@QueryParam("email") String email) {
        Optional<UserRecord> user = getUserImpl.getUser(email);
        return Response.ok(user.get()).build();
    }
}
