package com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository;

import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
