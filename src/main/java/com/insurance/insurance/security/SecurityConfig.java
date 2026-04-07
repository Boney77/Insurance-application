package com.insurance.insurance.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // 🔓 Public APIs
                .requestMatchers("/auth/**").permitAll()

                // 👑 ADMIN → ONLY CREATE POLICY
                .requestMatchers(HttpMethod.POST, "/policies")
                .hasRole("ADMIN")

                // 👤 + 👑 BOTH → VIEW POLICIES
                .requestMatchers(HttpMethod.GET, "/policies/**")
                .hasAnyRole("USER", "ADMIN")

                // 👤 USER → BUY POLICY
                .requestMatchers("/purchase/**").hasRole("USER")

                // 🔒 All other requests
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}