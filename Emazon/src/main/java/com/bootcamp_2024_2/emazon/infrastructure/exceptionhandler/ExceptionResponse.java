package com.bootcamp_2024_2.emazon.infrastructure.exceptionhandler;

import lombok.Getter;

@Getter
public enum ExceptionResponse {

    ROLE_NOT_FOUND("ERR_ROLE_001", "Role not found."),
    INVALID_ROLE("ERR_ROLE_002", "Invalid role parameters."),
    GENERIC_ERROR("ERR_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;

    ExceptionResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
