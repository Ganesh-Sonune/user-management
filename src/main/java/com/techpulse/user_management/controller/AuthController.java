package com.techpulse.user_management.controller;

import com.techpulse.user_management.dto.RegisterRequest;
import com.techpulse.user_management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.techpulse.user_management.dto.LoginRequest;

import com.techpulse.user_management.dto.ApiResponse;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ApiResponse<String> register(@Valid @RequestBody RegisterRequest request) {
        String message = userService.register(request);
        return new ApiResponse<>(true, message, null);
    }
    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return new ApiResponse<>(true, "Login successful", token);
    }


}
