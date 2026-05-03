package com.orderstream.auth.service;

import org.springframework.stereotype.Service;

import com.orderstream.auth.entity.User;
import com.orderstream.auth.repository.UserRepository;
import com.orderstream.auth.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class AuthService {
	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String login(String username, String password) {

        logger.info("Login attempt for user: {}", username);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    logger.error("User not found: {}", username);
                    return new RuntimeException("User not found");
                });

        if (!user.getPassword().equals(password)) {
            logger.warn("Invalid password for user: {}", username);
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(username);

        logger.info("Login successful for user: {}", username);

        return token;
    }
}