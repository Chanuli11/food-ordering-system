package com.ijse.foodsystem.dto;

/**
 * LoginRequest holds email and password for login.
 */
public class LoginRequest {

    // User's email address
    private String email;

    // User's password
    private String password;

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}