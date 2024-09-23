package com.bootcamp_2024_2.emazon.domain.api;

import com.bootcamp_2024_2.emazon.domain.model.User;

public interface IUserServicePort {
    User findById(Long id);
    User save(User user);
    User findByEmail(String email);
}
