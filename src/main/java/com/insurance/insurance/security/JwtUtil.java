package com.insurance.insurance.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // =========================
    // GENERATE TOKEN (WITH ROLE)
    // =========================
    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)   // 🔥 ADD ROLE HERE
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET_KEY)
                .compact();
    }

    // =========================
    // EXTRACT EMAIL
    // =========================
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractUsername(String token) {
        return extractEmail(token);
    }

    // =========================
    // 🔥 EXTRACT ROLE (NEW)
    // =========================
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // =========================
    // VALIDATE TOKEN
    // =========================
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // =========================
    // CHECK EXPIRATION
    // =========================
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // =========================
    // 🔧 COMMON METHOD (CLEAN CODE)
    // =========================
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}