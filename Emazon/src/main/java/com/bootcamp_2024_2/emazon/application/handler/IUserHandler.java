package com.bootcamp_2024_2.emazon.application.handler;

import com.bootcamp_2024_2.emazon.application.dto.request.UserRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.UserResponse;

public interface IUserHandler {
    UserResponse findById(Long id);
    UserResponse save(UserRequest user);
}
