package com.ijse.foodsystem.dto;

/**
 * RegisterRequest holds data sent by user during registration.
 */
public class RegisterRequest {

    // User's full name
    private String name;

    // User's email address
    private String email;

    // User's chosen password
    private String password;

    // User's role (ADMIN or CUSTOMER)
    private String role;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}