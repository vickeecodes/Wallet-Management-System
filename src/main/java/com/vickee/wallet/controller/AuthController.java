package com.vickee.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vickee.wallet.dao.LoginRequest;
import com.vickee.wallet.dao.RegisterRequest;
import com.vickee.wallet.dto.LoginResponse;
import com.vickee.wallet.dto.RegisterResponse;
import com.vickee.wallet.service.UserService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth APIs", description = "User authentication APIs (Register & Login)")
public class AuthController {

    @Autowired
    private UserService userService;

    @Operation(
        summary = "Register new user",
        description = "Creates a new user account with name, email and password"
    )
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }

    @Operation(
        summary = "Login user",
        description = "Authenticates user and returns login response"
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }
}