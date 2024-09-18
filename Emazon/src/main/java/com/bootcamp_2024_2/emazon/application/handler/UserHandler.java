package com.bootcamp_2024_2.emazon.application.handler;

import com.bootcamp_2024_2.emazon.application.dto.request.UserRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.UserResponse;
import com.bootcamp_2024_2.emazon.application.mapper.request.UserRequestMapper;
import com.bootcamp_2024_2.emazon.application.mapper.response.UserResponseMapper;
import com.bootcamp_2024_2.emazon.domain.api.IUserServicePort;
import com.bootcamp_2024_2.emazon.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler{

    private final IUserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserResponse findById(Long id) {
        User user = userServicePort.findById(id);
        return userResponseMapper.toResponse(user);
    }

    @Override
    public UserResponse save(UserRequest user) {
        return userResponseMapper.toResponse(userServicePort.save(userRequestMapper.toUser(user)));
    }
}
