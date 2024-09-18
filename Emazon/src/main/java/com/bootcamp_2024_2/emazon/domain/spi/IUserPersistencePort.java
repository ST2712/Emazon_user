package com.bootcamp_2024_2.emazon.domain.spi;

import com.bootcamp_2024_2.emazon.domain.model.User;

import java.util.Optional;

public interface IUserPersistencePort {
    Optional<User> findById(Long id);
    User save(User user);
}
