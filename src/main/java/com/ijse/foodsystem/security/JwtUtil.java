package com.ijse.foodsystem.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * JwtUtil provides utility methods for generating,
 * extracting, and validating JWT tokens.
 */
@Component
public class JwtUtil {

    // JWT secret key from application.properties
    @Value("${jwt.secret}")
    private String secret;

    // JWT expiration time in milliseconds
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * Creates a signing key from the secret string.
     */
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    /**
     * Generates a JWT token for the given email.
     */
    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    /**
     * Extracts the email (subject) from a JWT token.
     */
    public String extractEmail(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    /**
     * Validates a JWT token.
     * Returns true if valid, false if expired or invalid.
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            // Token is invalid or expired
            return false;
        }
    }
}