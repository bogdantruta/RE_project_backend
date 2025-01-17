package com.sprinters.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {
    ADMIN,
    USER,
    ORGANIZATION;

    @Override
    public String getAuthority() {
        return name();
    }
}
