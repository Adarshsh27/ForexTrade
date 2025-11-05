package com.forextrade.microservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String emailId;
    private String password;
    private String country;
    private String fullName;
    private String role = "user";
}
