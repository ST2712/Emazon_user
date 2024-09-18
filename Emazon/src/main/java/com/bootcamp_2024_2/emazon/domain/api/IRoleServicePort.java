package com.bootcamp_2024_2.emazon.domain.api;

import com.bootcamp_2024_2.emazon.domain.model.Role;

public interface IRoleServicePort {
    Role findById(Long id);
    Role save(Role role);
}
