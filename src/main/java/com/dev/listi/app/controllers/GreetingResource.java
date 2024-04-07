package com.dev.listi.app.controllers;

import com.dev.listi.app.services.api.UserService;
import com.dev.listi.app.usecases.CreateUserUseCase;
import com.dev.listi.app.usecases.GetUserUseCase;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.vo.Email;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.annotations.Param;

import java.util.Optional;

@Path("/users")
public class GreetingResource {

    @Inject
    UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create() {
        return userService.createUser();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("email") String email) {
        return userService.getUser(email);
    }


}
