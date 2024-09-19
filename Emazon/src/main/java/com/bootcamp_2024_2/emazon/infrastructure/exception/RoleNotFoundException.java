package com.bootcamp_2024_2.emazon.infrastructure.exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message){
        super(message);
    }
    public RoleNotFoundException(){

    }
}
