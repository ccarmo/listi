package com.dev.listi.user.application.resource;

import com.dev.listi.user.application.dto.UserRecord;
import com.dev.listi.user.application.usecase.CreateUserUseCase;
import com.dev.listi.user.application.usecase.GetUserUseCase;
import com.dev.listi.auth.Secured;
import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

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
    public Response create(@QueryParam("name") String name, @QueryParam("phone") String phone, @QueryParam("email") String email) {
        logger.info("Recebida requisição para criar usuário");
        logger.fine("Nome do usuário: " + name);
        
        Optional<UserRecord> userRecord = createUserUseCase.createUser(name, phone, email);
        if (userRecord.isPresent()) {
            logger.info("Usuário criado com sucesso");
            logger.fine("ID do usuário criado: " + userRecord.get());
            return Response.ok(userRecord.get()).build();
        } else {
            logger.warning("Falha ao criar usuário");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Secured
    public Response get(@QueryParam("email") String email) {
        logger.info("Recebida requisição para buscar usuário");
        logger.fine("Email buscado: " + email);
        
        Optional<UserRecord> user = getUserUseCase.getUser(email);
        if (user.isPresent()) {
            logger.info("Usuário encontrado com sucesso");
            logger.fine("ID do usuário encontrado: " + user.get());
            return Response.ok(user.get()).build();
        } else {
            logger.warning("Usuário não encontrado para o email: " + email);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}