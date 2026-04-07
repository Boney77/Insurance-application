package com.insurance.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.insurance.insurance.entity.Policy;
import com.insurance.insurance.repository.PolicyRepository;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepo;

    // =========================
    // GET ALL POLICIES
    // =========================
    public List<Policy> getAllPolicies() {
        return policyRepo.findAll();
    }

    // =========================
    // ADD NEW POLICY
    // =========================
    public Policy addPolicy(Policy policy) {
        return policyRepo.save(policy);
    }
}