package com.insurance.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.insurance.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}