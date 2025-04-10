package com.dev.listi.os.application.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

// CreateOSResponse
@Schema(description = "Resposta após a criação de uma ordem de serviço.")
public class CreateOSResponse {
    @Schema(description = "ID da ordem de serviço.", example = "101")
    public Integer id;

    @Schema(description = "Link gerencial da OS.", example = "https://api.minhasos.com/os/101/gerencial")
    public String linkGerencial;

    @Schema(description = "Link de acompanhamento da OS.", example = "https://api.minhasos.com/os/101/acompanhamento")
    public String linkAcompanhamento;
}