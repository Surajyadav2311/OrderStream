package com.orderstream.auth.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String token;
    public LoginResponse(String token) {
        this.token = token;
    }
}
