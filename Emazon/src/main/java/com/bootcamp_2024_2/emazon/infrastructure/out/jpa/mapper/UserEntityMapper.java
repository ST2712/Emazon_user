package com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper;

import com.bootcamp_2024_2.emazon.domain.model.User;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.UserEntity;

public interface UserEntityMapper {
    User toUser(UserEntity userEntity);
    UserEntity toEntityUser(User user);
}
