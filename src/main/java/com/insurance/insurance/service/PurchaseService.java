package com.insurance.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import com.insurance.insurance.entity.*;
import com.insurance.insurance.repository.*;
import com.insurance.insurance.exception.ResourceNotFoundException;

// 🔥 NEW IMPORTS
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepo;

    @Autowired
    private PolicyRepository policyRepo;

    @Autowired
    private UserRepository userRepo;

    // =========================
    // 🔥 GET LOGGED-IN USER FROM JWT
    // =========================
    private User getLoggedInUser() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String email;

        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }

        return userRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // =========================
    // BUY POLICY
    // =========================
    public String buyPolicy(Long policyId) {

        // ✅ STEP 3 APPLIED
        User user = getLoggedInUser();

        Policy policy = policyRepo.findById(policyId)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));

        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setPolicy(policy);
        purchase.setPurchaseDate(LocalDate.now());

        purchaseRepo.save(purchase);

        return "Policy purchased successfully";
    }

    // =========================
    // GET USER PURCHASES
    // =========================
    public List<Purchase> getUserPurchases() {

        // ✅ STEP 4 APPLIED
        User user = getLoggedInUser();

        return purchaseRepo.findByUser(user);
    }
}