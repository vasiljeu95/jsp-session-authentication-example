package com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.model;

public enum UserRole {

    USER_ROLE("user"),
    ADMIN_ROLE("admin");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
