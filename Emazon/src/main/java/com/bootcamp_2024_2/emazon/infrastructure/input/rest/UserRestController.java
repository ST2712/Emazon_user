package com.bootcamp_2024_2.emazon.infrastructure.input.rest;

import com.bootcamp_2024_2.emazon.application.dto.response.UserResponse;
import com.bootcamp_2024_2.emazon.application.handler.UserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserHandler userHandler;

    @GetMapping(path = "/v1/users/{id}")
    @Operation(summary = "Retrieve a user by ID", description = "Returns the details of a specific user identified by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class))}),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public UserResponse getRole(
            @Parameter(description = "ID of the user to be retrieved", example = "1")
            @PathVariable Long id) {
        return userHandler.findById(id);
    }

    @PostMapping(path = "/v1/users")
    public UserResponse getByEmail(
            @Parameter(description = "Email of the user to be retrieved", example = "email@gmail.com")
            @RequestBody String email) {
        return userHandler.findByEmail(email);
    }
}
