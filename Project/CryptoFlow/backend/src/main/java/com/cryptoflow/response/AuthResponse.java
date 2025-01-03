package com.cryptoflow.response;

import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;
    private String message;
    private String session;
    private boolean status;
    private boolean isTwoFactorAuthEnabled;
}
