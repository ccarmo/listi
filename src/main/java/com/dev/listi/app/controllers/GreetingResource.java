package com.dev.listi.app.controllers;

import com.dev.listi.app.usecases.CreateUserUseCase;
import com.dev.listi.domain.entities.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/users")
public class GreetingResource {


    @Inject
    CreateUserUseCase createUserUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Optional<User> create() {
        User user = new User("Carmo");
        return createUserUseCase.createUser(user);
    }
}
