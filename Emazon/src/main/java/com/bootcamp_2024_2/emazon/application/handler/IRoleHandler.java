package com.bootcamp_2024_2.emazon.application.handler;

import com.bootcamp_2024_2.emazon.application.dto.request.RoleRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.RoleResponse;

public interface IRoleHandler {
    RoleResponse findById(Long id);
    RoleResponse save(RoleRequest role);
}
