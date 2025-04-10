package com.dev.listi.linkmanagement.application.resource;


import com.dev.listi.linkmanagement.application.dto.SendEmailRequest;
import com.dev.listi.linkmanagement.application.dto.ShareLinksResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/links")
@Tag(name = "Links", description = "Operações relacionadas ao gerenciamento de links.")
public class LinkManagementResource {


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
}
