package com.dev.listi.app.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

// UpdateOSRequest
@Schema(description = "Modelo para atualização de uma ordem de serviço.")
public class UpdateOSRequest {
    @Schema(description = "Novo status da OS.", example = "Concluída")
    public String status;

    @Schema(description = "Nova descrição da OS.", example = "Manutenção finalizada com sucesso.")
    public String descricao;

    @Schema(description = "Novas observações.", example = "Equipamento entregue ao cliente.")
    public String observacoes;
}