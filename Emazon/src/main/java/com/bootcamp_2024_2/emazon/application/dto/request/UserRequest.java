package com.bootcamp_2024_2.emazon.application.dto.request;

import com.bootcamp_2024_2.emazon.domain.model.Role;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Identification is required")
    @Positive(message = "Identification must be positive")
    private int identification;

    @NotBlank(message = "Phone is required")
    @Size(min = 10, max = 13, message = "Phone must have 13 digits")
    private String phone;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotNull(message = "Role id is required")
    @Positive
    private Long roleId;
}
