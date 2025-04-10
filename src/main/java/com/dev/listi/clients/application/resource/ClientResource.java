package com.dev.listi.clients.application.resource;

import com.dev.listi.clients.application.dto.ClientRecord;
import com.dev.listi.clients.application.dto.CreateClientRequest;
import com.dev.listi.clients.application.usecase.CreateClientUseCase;
import com.dev.listi.clients.application.usecase.GetClientUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject
    CreateClientUseCase createClientUseCase;

    @Inject
    GetClientUseCase getClientUseCase;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClient(CreateClientRequest createClientRequest) {
        createClientUseCase.createClient(createClientRequest);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllClients() {
        String email = "teste@teste.com";
        List<ClientRecord> clientRecordList = getClientUseCase.listAllClients(email);
        return Response.status(Response.Status.OK).entity(clientRecordList).build();
    }
}