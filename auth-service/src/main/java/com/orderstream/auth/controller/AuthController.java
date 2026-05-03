package com.orderstream.auth.controller;

import com.orderstream.auth.dto.LoginRequest;
import com.orderstream.auth.dto.LoginResponse;
import com.orderstream.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
	

    private final AuthService authService;
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        String token = authService.login(
                request.getUsername(),
                request.getPassword()
        );

        return new LoginResponse(token);
    }
}