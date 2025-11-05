package com.forextrade.microservice.controller;

import com.forextrade.microservice.config.jwt.JwtUtils;
import com.forextrade.microservice.config.security.UserPrincipal;
import com.forextrade.microservice.dto.UserDTO;
import com.forextrade.microservice.request.LoginRequest;
import com.forextrade.microservice.request.RegisterRequest;
import com.forextrade.microservice.response.ApiResponse;
import com.forextrade.microservice.response.JwtResponse;
import com.forextrade.microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody RegisterRequest registerRequest){
        return userService.regiserUser(registerRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@Validated @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail() , loginRequest.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateTokenForUser(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        JwtResponse jwtResponse = new JwtResponse(userPrincipal.getUser().getUserId(), jwt);
        return ResponseEntity.ok(new ApiResponse("Login Successful" , jwtResponse));
    }
}
