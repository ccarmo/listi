package com.dev.listi.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Modelo para criação de uma ordem de serviço.")
public class CreateOSRequest {
    @Schema(description = "ID do cliente.", example = "1")
    @JsonProperty("idCliente")
    public Integer idClient;

    @Schema(description = "Descrição da ordem de serviço.", example = "Manutenção do equipamento X.")
    @JsonProperty("descricao")
    public String description;

    @Schema(description = "Observações adicionais.", example = "Cliente solicitou urgência no serviço.")
    @JsonProperty("observacoes")
    public String notes;
}

