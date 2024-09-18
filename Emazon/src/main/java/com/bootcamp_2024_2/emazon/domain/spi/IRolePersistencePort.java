package com.bootcamp_2024_2.emazon.domain.spi;

import com.bootcamp_2024_2.emazon.domain.model.Role;

import java.util.Optional;

public interface IRolePersistencePort {
    Optional<Role> findById(Long id);
    Role save(Role role);
}
