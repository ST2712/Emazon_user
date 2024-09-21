package com.bootcamp_2024_2.emazon.infrastructure.configuration.security;

import com.bootcamp_2024_2.emazon.application.dto.request.UserRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.UserResponse;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.UserEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper.RoleEntityMapper;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IRoleRepository;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            IUserRepository userRepository,
            IRoleRepository roleRepository,
            RoleEntityMapper roleEntityMapper,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleEntityMapper = roleEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse signup(UserRequest input) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(input.getName());
        userEntity.setLastName(input.getLastName());
        userEntity.setIdentification(input.getIdentification());
        userEntity.setPhone(input.getPhone());
        userEntity.setDateOfBirth(input.getDateOfBirth());
        userEntity.setEmail(input.getEmail());
        userEntity.setPassword(passwordEncoder.encode(input.getPassword()));
        userEntity.setRole(roleRepository.findById(input.getRoleId()).orElseThrow(() -> new RuntimeException("Role not found")));

        UserEntity user = userRepository.save(userEntity);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setLastName(user.getLastName());
        userResponse.setIdentification(user.getIdentification());
        userResponse.setPhone(user.getPhone());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setRole(roleEntityMapper.toRole(user.getRole()));
        return userResponse;
    }

    public UserEntity authenticate(UserRequest input) {
        UserEntity user = userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return user;
    }

}
