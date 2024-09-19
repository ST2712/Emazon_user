package com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository;

import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
    public Optional<RoleEntity> findById(Long id);
}
