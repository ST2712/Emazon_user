package com.bootcamp_2024_2.emazon.application.handler;

import com.bootcamp_2024_2.emazon.application.dto.request.RoleRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.RoleResponse;
import com.bootcamp_2024_2.emazon.application.mapper.request.RoleRequestMapper;
import com.bootcamp_2024_2.emazon.application.mapper.response.RoleResponseMapper;
import com.bootcamp_2024_2.emazon.domain.api.IRoleServicePort;
import com.bootcamp_2024_2.emazon.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandler implements IRoleHandler{

    private final IRoleServicePort roleServicePort;
    private final RoleRequestMapper roleRequestMapper;
    private final RoleResponseMapper roleResponseMapper;

    @Override
    public RoleResponse findById(Long id) {
        Role role = roleServicePort.findById(id);
        return roleResponseMapper.toResponse(role);
    }

    @Override
    public RoleResponse save(RoleRequest role) {
        return roleResponseMapper.toResponse(roleServicePort.save(roleRequestMapper.toRole(role)));
    }
}
