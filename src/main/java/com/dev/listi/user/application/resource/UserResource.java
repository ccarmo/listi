package com.dev.listi.user.application.resource;

import com.dev.listi.user.application.dto.UserRecord;
import com.dev.listi.user.application.usecase.CreateUserUseCase;
import com.dev.listi.user.application.usecase.GetUserUseCase;
import com.dev.listi.auth.Secured;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;
import java.util.logging.Logger;

@Path("/users")

public class UserResource {

    private static final Logger logger = Logger.getLogger(UserResource.class.getName());

    @Inject
    private GetUserUseCase getUserUseCase;

    @Inject
    private CreateUserUseCase createUserUseCase;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Secured
    public Response create(@QueryParam("name") String name) {
        logger.info("Received request to create user with name: " + name);
        Optional<UserRecord> userRecord = createUserUseCase.createUser(name);
        if (userRecord.isPresent()) {
            logger.info("User created successfully: " + userRecord.get());
            return Response.ok(userRecord.get()).build();
        } else {
            logger.warning("Failed to create user with name: " + name);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("email") String email) {
        logger.info("Received request to get user with email: " + email);
        Optional<UserRecord> user = getUserUseCase.getUser(email);
        if (user.isPresent()) {
            logger.info("User retrieved successfully: " + user.get());
            return Response.ok(user.get()).build();
        } else {
            logger.warning("User not found with email: " + email);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}