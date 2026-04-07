package com.insurance.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.insurance.insurance.dto.LoginRequest;
import com.insurance.insurance.dto.RegisterRequest;
import com.insurance.insurance.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    // Register API
    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        return service.register(request);
    }

    // Login API
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return service.login(request);
    }
}