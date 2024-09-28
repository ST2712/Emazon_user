package com.bootcamp_2024_2.emazon.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password should not be blank")
    private String password;
}
