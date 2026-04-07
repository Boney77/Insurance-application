package com.insurance.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.insurance.insurance.entity.Policy;
import com.insurance.insurance.service.PolicyService;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    @Autowired
    private PolicyService service;

    // Get all policies
    @GetMapping
    public List<Policy> getAllPolicies() {
        return service.getAllPolicies();
    }

    // Add policy (Admin)
    @PostMapping
    public Policy addPolicy(@RequestBody Policy policy) {
        return service.addPolicy(policy);
    }
}