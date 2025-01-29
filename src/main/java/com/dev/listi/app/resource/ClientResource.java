package com.dev.listi.app.resource;

import com.dev.listi.app.dto.CreateClientRequest;
import com.dev.listi.app.usecases.CreateClientUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject
    CreateClientUseCase createClientUseCase;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClient(CreateClientRequest createClientRequest) {
        createClientUseCase.createClient(createClientRequest);
        return Response.status(Response.Status.CREATED).build();
    }
}