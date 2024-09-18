package com.bootcamp_2024_2.emazon.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequest {

    @NotBlank(message = "Field name cannot be empty or null")
    private String name;

    @NotBlank(message = "Field description cannot be empty or null")
    private String description;
}
