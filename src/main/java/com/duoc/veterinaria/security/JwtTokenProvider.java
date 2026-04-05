package com.duoc.veterinaria.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String JWT_SECRET = "926eb5ee9111c191a329583110292728"; // Usa una clave segura
    private final long JWT_EXPIRATION = 604800000L;

    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception ex) { return false; }
    }
}