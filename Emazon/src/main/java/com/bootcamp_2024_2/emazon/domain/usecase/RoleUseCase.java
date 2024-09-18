package com.bootcamp_2024_2.emazon.domain.usecase;

import com.bootcamp_2024_2.emazon.domain.api.IRoleServicePort;
import com.bootcamp_2024_2.emazon.domain.model.Role;
import com.bootcamp_2024_2.emazon.domain.spi.IRolePersistencePort;
import com.bootcamp_2024_2.emazon.infrastructure.exception.RoleNotFoundException;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public Role findById(Long id) {
        return rolePersistencePort.findById(id)
                .orElseThrow(RoleNotFoundException::new);
    }

    @Override
    public Role save(Role role) {
        return rolePersistencePort.save(role);
    }
}
