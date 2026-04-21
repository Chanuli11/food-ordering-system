package com.ijse.foodsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User entity represents a system user.
 * Roles: ADMIN (manages food/categories) or CUSTOMER (places orders).
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Full name of the user
    private String name;

    // Email is unique and used for login
    @Column(unique = true, nullable = false)
    private String email;

    // Password is stored as BCrypt encoded hash
    @Column(nullable = false)
    private String password;

    // Role determines access level
    @Enumerated(EnumType.STRING)
    private Role role;

    // Available roles in the system
    public enum Role {
        ADMIN, CUSTOMER
    }
}