package com.dev.listi.auth.resource;

import com.dev.listi.auth.AuthRequest;
import com.dev.listi.auth.JwtTokenService;
import java.util.logging.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@RequestScoped
public class AuthResource {

    private static final Logger logger = Logger.getLogger(AuthResource.class.getName());

    @Inject
    JwtTokenService tokenService;

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(AuthRequest request) {
        logger.info("Tentativa de login recebida");
        
        if (request.getPhoneNumber() == null || request.getPhoneNumber().trim().isEmpty()) {
            logger.warning("Tentativa de login sem número de telefone");
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Número de telefone é obrigatório")
                    .build();
        }
        
        logger.info("Gerando token para o telefone: " + request.getPhoneNumber().substring(0, 3) + "***");
        String token = tokenService.generateToken(request.getPhoneNumber(), "USER");
        
        logger.info("Login realizado com sucesso");
        return Response.ok()
                .entity(new TokenResponse(token))
                .build();
    }
}

class TokenResponse {
    private String token;

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
} 