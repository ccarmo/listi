package com.dev.listi.os.application.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

// OSDetailsResponse
@Schema(description = "Detalhes de uma ordem de serviço.")
public class OSDetailsResponse {
    @Schema(description = "ID da ordem de serviço.", example = "101")
    public Integer id;

    @Schema(description = "ID do cliente associado à OS.", example = "1")
    public Integer idCliente;

    @Schema(description = "Descrição da OS.", example = "Manutenção do equipamento X.")
    public String descricao;

    @Schema(description = "Status atual da OS.", example = "Aberta")
    public String status;

    @Schema(description = "Data de criação da OS.", format = "date-time", example = "2023-07-15T10:00:00")
    public LocalDateTime dataCriacao;

    @Schema(description = "Observações adicionais.", example = "Cliente solicitou urgência no serviço.")
    public String observacoes;
}

