package com.dev.listi.service;

import com.dev.listi.app.dto.UserRecord;
import com.dev.listi.app.usecases.impl.CreateUserImpl;
import com.dev.listi.app.usecases.impl.GetUserImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Inject
    private GetUserImpl getUserImpl;

    @Inject
    private CreateUserImpl createUserImpl;

    public Response createUser(String name) {
        logger.info("Received request to create user with name: " + name);
        Optional<UserRecord> userRecord = createUserImpl.createUser(name);
        if (userRecord.isPresent()) {
            logger.info("User created successfully: " + userRecord.get());
            return Response.ok(userRecord.get()).build();
        } else {
            logger.warning("Failed to create user with name: " + name);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Response getUser(@QueryParam("email") String email) {
        logger.info("Received request to get user with email: " + email);
        Optional<UserRecord> user = getUserImpl.getUser(email);
        if (user.isPresent()) {
            logger.info("User retrieved successfully: " + user.get());
            return Response.ok(user.get()).build();
        } else {
            logger.warning("User not found with email: " + email);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}