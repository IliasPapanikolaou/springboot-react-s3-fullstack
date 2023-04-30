package com.ipap.backendapi.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
