package com.dev.listi.app.resource;

import com.dev.listi.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/users")
public class UserResource {

    private static final Logger logger = Logger.getLogger(UserResource.class.getName());

    @Inject
    UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@QueryParam("name") String name) {
        logger.info("Received request to create user with name: " + name);
        Response response = userService.createUser(name);
        logger.info("Response for create user: " + response.getStatus());
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("email") String email) {
        logger.info("Received request to get user with email: " + email);
        Response response = userService.getUser(email);
        logger.info("Response for get user: " + response.getStatus());
        return response;
    }
}