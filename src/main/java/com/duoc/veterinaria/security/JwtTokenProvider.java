package com.duoc.veterinaria.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // Borra la línea que tenía el código secreto escrito
    @Value("${app.jwt.secret}") 
    private String jwtSecret;

    private final long JWT_EXPIRATION = 604800000L;

    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, jwtSecret) // Usa la variable inyectada
                .compact();
    }
}