package com.dev.listi.os.application.resource;

import com.dev.listi.linkmanagement.application.dto.SendEmailRequest;
import com.dev.listi.linkmanagement.application.dto.ShareLinksResponse;
import com.dev.listi.os.application.UpdateOS;
import com.dev.listi.os.application.dto.CreateOSRequest;
import com.dev.listi.os.application.CreateOrderUseCase;
import com.dev.listi.os.application.dto.OSDetailsResponse;
import com.dev.listi.os.application.dto.UpdateOSRequest;
import com.dev.listi.os.core.enums.StatusOS;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/os")
@Tag(name = "Ordem de Serviço", description = "Operações relacionadas às ordens de serviço.")
public class OrdemServicoResource {

    @Inject
    CreateOrderUseCase createOrderUseCase;

    @Inject
    UpdateOS updateOS;

    @POST
    @Operation(summary = "Criar uma nova ordem de serviço", description = "Cria uma OS com informações do cliente, descrição e observações.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response criarOrdemServico(CreateOSRequest request) {
        createOrderUseCase.execute(request);
        return Response.status(Response.Status.CREATED).entity(request).build();
    }

    // Endpoint para Listar as Ordens de Serviço
    @GET
    @Operation(summary = "Listar ordens de serviço", description = "Lista todas as OS com filtros por status e documento cliente.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarOrdensServico(@QueryParam("status") String status, @QueryParam("documento") String documento) {
        List<OSDetailsResponse> osList = List.of(new OSDetailsResponse()); // Exemplo de lista
        //return Response.ok(new ListOSResponse(osList)).build();
        return null;
    }

    // Endpoint para Detalhar uma Ordem de Serviço
    @GET
    @Path("/{osId}")
    @Operation(summary = "Detalhar uma OS", description = "Retorna informações detalhadas de uma OS pelo ID.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response detalharOrdemServico(@PathParam("osId") @Parameter(description = "ID da OS.") Long osId) {
        OSDetailsResponse os = new OSDetailsResponse(); // Exemplo de detalhes
        return Response.ok(os).build();
    }

    // Endpoint para Atualizar uma Ordem de Serviço
    @PATCH
    @Path("/{osId}/status")
    @Operation(summary = "Atualizar status ou informações de uma OS", description = "Atualiza status, descrição ou observações de uma OS específica.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStatus(@PathParam("osId") @Parameter(description = "ID da OS.") Long osId, UpdateOSRequest request) {
        updateOS.status(osId, request.status);
        return Response.ok().build();
    }

    // Endpoint para Atualizar uma Ordem de Serviço
    @PATCH
    @Path("/{osId}/description")
    @Operation(summary = "Atualizar status ou informações de uma OS", description = "Atualiza status, descrição ou observações de uma OS específica.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDescription(@PathParam("osId") @Parameter(description = "ID da OS.") Long osId, UpdateOSRequest request) {
        updateOS.status(osId, request.descricao);
        return Response.ok().build();
    }

    // Endpoint para Atualizar uma Ordem de Serviço
    @PATCH
    @Path("/{osId}/notes")
    @Operation(summary = "Atualizar status ou informações de uma OS", description = "Atualiza status, descrição ou observações de uma OS específica.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNotes(@PathParam("osId") @Parameter(description = "ID da OS.") Long osId, UpdateOSRequest request) {
        updateOS.status(osId, request.observacoes);
        return Response.ok().build();
    }





}
