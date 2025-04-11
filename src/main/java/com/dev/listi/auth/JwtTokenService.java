package com.dev.listi.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@ApplicationScoped
public class JwtTokenService {

    @ConfigProperty(name = "jwt.secret")
    String secretKeyConfig;

    @ConfigProperty(name = "jwt.expiration", defaultValue = "3600000")
    Long expirationTime;

    // Método para obter a chave secreta
    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKeyConfig.getBytes(StandardCharsets.UTF_8));
    }

    // Método para gerar o token
    public String generateToken(String subject, String role) {
        return generateToken(subject, role, expirationTime);
    }

    public String generateToken(String subject, String role, long customExpirationMillis) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + customExpirationMillis);

        return Jwts.builder()
                .subject(subject)
                .claim("role", role)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSecretKey())
                .compact();
    }

    // Método para gerar o token com claims customizadas
    public String generateTokenWithClaims(Map<String, Object> claims, String subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .subject(subject)
                .claims(claims)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSecretKey())
                .compact();
    }
}
