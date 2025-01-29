package com.dev.listi.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Modelo para criação de uma ordem de serviço.")
public record CreateOSRequest(
    @Schema(description = "ID do cliente.", example = "1")
    @JsonProperty("idCliente") Integer idClient,

    @Schema(description = "ID do cliente.", example = "1")
    @JsonProperty("idUser") Integer idUser,

    @Schema(description = "Descrição da ordem de serviço.", example = "Manutenção do equipamento X.")
    @JsonProperty("descricao") String description,

    @Schema(description = "Observações adicionais.", example = "Cliente solicitou urgência no serviço.")
    @JsonProperty("observacoes") String notes
) {}