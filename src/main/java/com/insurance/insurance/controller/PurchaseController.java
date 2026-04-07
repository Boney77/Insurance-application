package com.insurance.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.insurance.insurance.entity.Purchase;
import com.insurance.insurance.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    // Buy policy
    @PostMapping("/{policyId}")
    public String buyPolicy(@PathVariable Long policyId) {
        return service.buyPolicy(policyId);
    }

    // View user purchases
    @GetMapping
    public List<Purchase> getPurchases() {
        return service.getUserPurchases();
    }
}