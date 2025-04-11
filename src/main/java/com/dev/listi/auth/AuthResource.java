package com.dev.listi.auth;

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

    @Inject
    JwtTokenService tokenService;

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(AuthRequest request) {
        if (request.getPhoneNumber() == null || request.getPhoneNumber().trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Número de telefone é obrigatório")
                    .build();
        }
        
        String token = tokenService.generateToken(request.getPhoneNumber(), "USER");
        
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