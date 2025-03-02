package com.example.springboot.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private final String description;

    Role(String description) {

        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
