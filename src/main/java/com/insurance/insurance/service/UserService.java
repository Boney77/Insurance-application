package com.insurance.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.insurance.dto.*;
import com.insurance.insurance.entity.User;
import com.insurance.insurance.repository.UserRepository;
import com.insurance.insurance.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    // =========================
    // REGISTER USER
    // =========================
    public String register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        // Set default role
        user.setRole("USER");

        userRepo.save(user);

        return "User registered successfully";
    }

    // =========================
    // LOGIN USER
    // =========================
    public String login(LoginRequest request) {

        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Generate JWT Token WITH ROLE
        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }
}