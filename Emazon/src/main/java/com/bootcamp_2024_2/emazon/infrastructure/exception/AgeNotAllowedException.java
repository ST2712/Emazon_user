package com.bootcamp_2024_2.emazon.infrastructure.exception;

public class AgeNotAllowedException extends RuntimeException {
    public AgeNotAllowedException(String message) {
        super(message);
    }
}
