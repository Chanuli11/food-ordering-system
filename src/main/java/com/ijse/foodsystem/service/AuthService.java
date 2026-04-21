package com.ijse.foodsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ijse.foodsystem.dto.AuthResponse;
import com.ijse.foodsystem.dto.LoginRequest;
import com.ijse.foodsystem.dto.RegisterRequest;
import com.ijse.foodsystem.entity.User;
import com.ijse.foodsystem.repository.UserRepository;
import com.ijse.foodsystem.security.JwtUtil;

/**
 * AuthService handles user registration and login logic.
 * It encodes passwords securely and generates JWT tokens.
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Registers a new user with their own password.
     * Password is encoded using BCrypt before saving.
     */
    public AuthResponse register(RegisterRequest request) {
        // Check if email is already registered
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use!");
        }

        // Create new user and set fields
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Encode password
        user.setRole(User.Role.valueOf(request.getRole().toUpperCase()));

        // Save user to database
        userRepository.save(user);

        // Generate JWT token and return response
        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, user.getEmail(), user.getRole().name());
    }

    /**
     * Authenticates a user and returns a JWT token on success.
     */
    public AuthResponse login(LoginRequest request) {
        // Authenticate using Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Find user by email
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // Generate JWT token and return response
        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, user.getEmail(), user.getRole().name());
    }
}