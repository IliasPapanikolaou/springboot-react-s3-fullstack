package com.ipap.backendapi.auth;

public record AuthenticationRequest(
        String username,
        String password) {
}
