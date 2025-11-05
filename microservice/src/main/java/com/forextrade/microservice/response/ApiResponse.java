package com.forextrade.microservice.response;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private Object body;
}
