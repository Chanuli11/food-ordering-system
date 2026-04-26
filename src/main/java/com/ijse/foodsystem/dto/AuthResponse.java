package com.ijse.foodsystem.dto;

/**
 * AuthResponse returns JWT token, email, role and id after login/register.
 */
public class AuthResponse {

    // User ID
    private Long id;

    // JWT token for authentication
    private String token;

    // User's email
    private String email;

    // User's role (ADMIN or CUSTOMER)
    private String role;

    // Constructor
    public AuthResponse(Long id, String token, String email, String role) {
        this.id = id;
        this.token = token;
        this.email = email;
        this.role = role;
    }

    // Getters
    public Long getId() { return id; }
    public String getToken() { return token; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}