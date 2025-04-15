package com.dev.listi.auth;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
@ApplicationScoped
public class JwtAuthenticationFilter implements ContainerRequestFilter {

    @ConfigProperty(name = "jwt.secret")
    String secretKeyConfig;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKeyConfig.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeader = requestContext.getHeaderString("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            requestContext.abortWith(Response.status(401).entity("Token JWT ausente").build());
            return;
        }

        String token = authHeader.substring(7);

        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String phone = claims.getSubject();
            String role = claims.get("role", String.class);
          

            requestContext.setProperty("phoneNumber", phone);
            requestContext.setProperty("role", role);
  

        } catch (JwtException e) {
            requestContext.abortWith(Response.status(401).entity("Token JWT inválido ou expirado").build());
        }
    }
}
