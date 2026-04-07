package com.insurance.insurance.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @Email(message = "Invalid email")
    @NotBlank
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;
}