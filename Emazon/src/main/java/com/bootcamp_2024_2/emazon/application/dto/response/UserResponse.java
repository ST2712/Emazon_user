package com.bootcamp_2024_2.emazon.application.dto.response;

import com.bootcamp_2024_2.emazon.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponse {

    private String name;
    private String lastName;
    private int identification;
    private String phone;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Role role;
}
