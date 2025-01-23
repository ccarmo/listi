package com.dev.listi.app.resource;

import com.dev.listi.app.dto.*;
import com.dev.listi.ordermanagement.application.dto.CreateOSRequest;
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

    // Endpoint para Criar uma nova Ordem de Serviço
    @POST
    @Operation(summary = "Criar uma nova ordem de serviço", description = "Cria uma OS com informações do cliente, descrição e observações.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarOrdemServico(CreateOSRequest request) {
        // Lógica para criar a OS
        CreateOSResponse response = new CreateOSResponse(); // Exemplo de resposta
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    // Endpoint para Listar as Ordens de Serviço
    @GET
    @Operation(summary = "Listar ordens de serviço", description = "Lista todas as OS com filtros por status e busca por número ou cliente.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarOrdensServico(@QueryParam("status") String status, @QueryParam("busca") String busca) {
        List<OSDetailsResponse> osList = List.of(new OSDetailsResponse()); // Exemplo de lista
        //return Response.ok(new ListOSResponse(osList)).build();
        return null;
    }

    // Endpoint para Detalhar uma Ordem de Serviço
    @GET
    @Path("/{osId}")
    @Operation(summary = "Detalhar uma OS", description = "Retorna informações detalhadas de uma OS pelo ID.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response detalharOrdemServico(@PathParam("osId") @Parameter(description = "ID da OS.") int osId) {
        OSDetailsResponse os = new OSDetailsResponse(); // Exemplo de detalhes
        return Response.ok(os).build();
    }

    // Endpoint para Atualizar uma Ordem de Serviço
    @PATCH
    @Path("/{osId}")
    @Operation(summary = "Atualizar status ou informações de uma OS", description = "Atualiza status, descrição ou observações de uma OS específica.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarOrdemServico(@PathParam("osId") @Parameter(description = "ID da OS.") int osId, UpdateOSRequest request) {
        // Lógica para atualizar a OS
        return Response.ok().build();
    }

    // Endpoint para Excluir uma Ordem de Serviço
    @DELETE
    @Path("/{osId}")
    @Operation(summary = "Excluir uma OS", description = "Exclui uma OS pelo ID.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirOrdemServico(@PathParam("osId") @Parameter(description = "ID da OS.") int osId) {
        // Lógica para excluir a OS
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    // Endpoint para Gerar Links de Compartilhamento
    @GET
    @Path("/{osId}/share")
    @Operation(summary = "Gerar links para acompanhamento e gerenciamento", description = "Retorna os links únicos de gerenciamento e acompanhamento para a OS.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gerarLinks(@PathParam("osId") @Parameter(description = "ID da OS.") int osId) {
        ShareLinksResponse links = new ShareLinksResponse(); // Exemplo de links
        return Response.ok(links).build();
    }

    // Endpoint para Enviar Link por E-mail
    @POST
    @Path("/{osId}/email")
    @Operation(summary = "Enviar link ao cliente por email", description = "Envia o link de acompanhamento para o cliente.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response enviarLinkPorEmail(@PathParam("osId") @Parameter(description = "ID da OS.") int osId, SendEmailRequest request) {
        // Lógica para enviar o e-mail
        return Response.ok().build();
    }

    // Endpoint para Exportar OS para PDF
    @GET
    @Path("/{osId}/export")
    @Operation(summary = "Exportar OS para PDF", description = "Gera um PDF da OS para download ou compartilhamento.")
    @Produces("application/pdf")
    public Response exportarOrdemServico(@PathParam("osId") @Parameter(description = "ID da OS.") int osId) {
        // Lógica para gerar PDF
        byte[] pdf = new byte[0]; // Exemplo de PDF gerado
        return Response.ok(pdf).build();
    }
}
