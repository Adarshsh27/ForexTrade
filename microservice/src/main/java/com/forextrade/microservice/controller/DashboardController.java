package com.forextrade.microservice.controller;

import com.forextrade.microservice.config.security.UserPrincipal;
import com.forextrade.microservice.model.User;
import com.forextrade.microservice.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
@Slf4j
public class DashboardController {
    @GetMapping("/wallet")
    public ResponseEntity<ApiResponse> getWallet(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        User user = userPrincipal.getUser();
        return ResponseEntity.ok(new ApiResponse("Here is the user Wallet" , user.getWallet()));
    }
}
