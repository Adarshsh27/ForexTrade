package com.forextrade.microservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.annotation.Nonnull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginRequest {
    @Nonnull
    private String email;
    @Nonnull
    private String password;
}
