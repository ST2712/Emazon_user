package com.bootcamp_2024_2.emazon.infrastructure.configuration.security;

import com.bootcamp_2024_2.emazon.application.dto.request.LoginRequest;
import com.bootcamp_2024_2.emazon.application.dto.request.UserRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.UserResponse;
import com.bootcamp_2024_2.emazon.application.handler.UserHandler;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.UserEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final AuthenticationManager authenticationManager;
    private final UserHandler userHandler;

    public AuthenticationService(
            IUserRepository userRepository,
            UserEntityMapper userEntityMapper,
            AuthenticationManager authenticationManager,
            UserHandler userHandler
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.userHandler = userHandler;
    }

    public UserResponse signup(UserRequest userRequest) {
        return userHandler.save(userRequest);
    }

    public UserEntity authenticate(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        return user;
    }

}
