package com.bootcamp_2024_2.emazon.application.mapper.response;

import com.bootcamp_2024_2.emazon.application.dto.response.UserResponse;
import com.bootcamp_2024_2.emazon.domain.model.User;

public interface UserResponseMapper {
    UserResponse toResponse(User user);
}
