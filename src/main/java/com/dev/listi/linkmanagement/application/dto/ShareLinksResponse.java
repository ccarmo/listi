package com.dev.listi.linkmanagement.application.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Resposta com os links de gerenciamento e acompanhamento.")
public class ShareLinksResponse {
    @Schema(description = "Link gerencial da OS.", example = "https://api.minhasos.com/os/101/gerencial")
    public String linkGerencial;

    @Schema(description = "Link de acompanhamento da OS.", example = "https://api.minhasos.com/os/101/acompanhamento")
    public String linkAcompanhamento;
}