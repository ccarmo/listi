package com.dev.listi.app.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

// SendEmailRequest
@Schema(description = "Modelo para envio de email com link de acompanhamento.")
public class SendEmailRequest {
    @Schema(description = "Email do cliente.", example = "cliente@example.com")
    public String emailCliente;

    @Schema(description = "Mensagem a ser enviada ao cliente.", example = "Segue o link para acompanhamento da sua ordem de serviço.")
    public String mensagem;
}