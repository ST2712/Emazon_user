package com.bootcamp_2024_2.emazon.infrastructure.input.rest;

import com.bootcamp_2024_2.emazon.application.dto.request.UserRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.UserResponse;
import com.bootcamp_2024_2.emazon.application.handler.UserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Create a new user", description = "Creates a new user with a unique name and description.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public ResponseEntity<UserResponse> createCategory(
            @Parameter(description = "Category data to be created", required = true)
            @Valid @RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userHandler.save(request));
    }
}
