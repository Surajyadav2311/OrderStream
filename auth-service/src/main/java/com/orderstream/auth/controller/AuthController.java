package com.orderstream.auth.controller;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.orderstream.auth.dto.LoginRequest;
import com.orderstream.auth.dto.LoginResponse;
import com.orderstream.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	private final AuthService authService;

	public AuthController(AuthService authService) {
	    this.authService = authService;
	}

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
    	logger.info("Received login request for user: {}", request.getUsername());

        String token = authService.login(
                request.getUsername(),
                request.getPassword()
        );
        logger.info("Token generated for user: {}", request.getUsername());
        return new LoginResponse(token);
    }
}