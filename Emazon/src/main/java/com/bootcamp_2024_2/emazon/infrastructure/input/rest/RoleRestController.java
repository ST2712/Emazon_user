package com.bootcamp_2024_2.emazon.infrastructure.input.rest;

import com.bootcamp_2024_2.emazon.application.dto.request.RoleRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.RoleResponse;
import com.bootcamp_2024_2.emazon.application.handler.RoleHandler;
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
@RequestMapping("/roles")
public class RoleRestController {

    private final RoleHandler roleHandler;

    @GetMapping(path = "/v1/roles/{id}")
    @Operation(summary = "Retrieve a role by ID", description = "Returns the details of a specific role identified by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the role",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoleResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Role not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public RoleResponse getRole(
            @Parameter(description = "ID of the role to be retrieved", example = "1")
            @PathVariable Long id) {
        return roleHandler.findById(id);
    }

    @PostMapping(path = "/v1/roles")
    @Operation(summary = "Create a new role", description = "Creates a new role with a unique name and description.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Role successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public ResponseEntity<RoleResponse> createCategory(
            @Parameter(description = "Category data to be created", required = true)
            @Valid @RequestBody RoleRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleHandler.save(request));
    }
}
