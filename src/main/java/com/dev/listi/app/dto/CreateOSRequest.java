package com.dev.listi.app.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Modelo para criação de uma ordem de serviço.")
public class CreateOSRequest {
    @Schema(description = "ID do cliente.", example = "1")
    public Integer idCliente;

    @Schema(description = "Descrição da ordem de serviço.", example = "Manutenção do equipamento X.")
    public String descricao;

    @Schema(description = "Observações adicionais.", example = "Cliente solicitou urgência no serviço.")
    public String observacoes;
}

