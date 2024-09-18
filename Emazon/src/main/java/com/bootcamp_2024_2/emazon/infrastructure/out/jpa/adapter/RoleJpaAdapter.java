package com.bootcamp_2024_2.emazon.infrastructure.out.jpa.adapter;

import com.bootcamp_2024_2.emazon.domain.model.Role;
import com.bootcamp_2024_2.emazon.domain.spi.IRolePersistencePort;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.RoleEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper.RoleEntityMapper;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {

    private final IRoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Optional<Role> findById(Long id) {
        Optional<RoleEntity> roleOptional = roleRepository.findById(id);
        return roleOptional.map(roleEntityMapper::toRole);
    }

    @Override
    public Role save(Role role) {
        RoleEntity roleEntity = roleRepository.save(roleEntityMapper.toEntityRole(role));
        RoleEntity savedRoleEntity = roleRepository.save(roleEntity);
        return roleEntityMapper.toRole(savedRoleEntity);
    }
}
