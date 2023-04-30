package com.ipap.backendapi.auth;

import com.ipap.backendapi.customer.CustomerDTO;

public record AuthenticationResponse (
        String token,
        CustomerDTO customerDTO
) {
}
