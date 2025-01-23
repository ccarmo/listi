package com.dev.listi.app.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

// ListOSResponse
@Schema(description = "Lista de ordens de serviço.")
public class ListOSResponse {
    @Schema(description = "Lista de detalhes de ordens de serviço.")
    public List<OSDetailsResponse> ordensDeServico;
}
