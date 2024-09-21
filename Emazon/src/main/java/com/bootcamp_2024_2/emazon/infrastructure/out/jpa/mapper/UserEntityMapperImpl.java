package com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper;

import com.bootcamp_2024_2.emazon.application.dto.request.UserRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.UserResponse;
import com.bootcamp_2024_2.emazon.domain.model.User;
import com.bootcamp_2024_2.emazon.infrastructure.exception.RoleNotFoundException;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.RoleEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.UserEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapperImpl implements UserEntityMapper {

    private final IRoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;
    private final PasswordEncoder passwordEncoder;

    public UserEntityMapperImpl(IRoleRepository roleRepository, RoleEntityMapper roleEntityMapper, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.roleEntityMapper = roleEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User toUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userEntity.getId() );
        user.setName( userEntity.getName() );
        user.setLastName( userEntity.getLastName() );
        user.setIdentification( userEntity.getIdentification() );
        user.setPhone( userEntity.getPhone() );
        user.setDateOfBirth( userEntity.getDateOfBirth() );
        user.setEmail( userEntity.getEmail() );
        user.setPassword( userEntity.getPassword() );
        user.setRoleId( userEntity.getRole().getId() );

        return user;
    }

    @Override
    public UserEntity toEntityUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setName( user.getName() );
        userEntity.setLastName( user.getLastName() );
        userEntity.setIdentification( user.getIdentification() );
        userEntity.setPhone( user.getPhone() );
        userEntity.setDateOfBirth( user.getDateOfBirth() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setPassword(user.getPassword());
        RoleEntity roleEntity = roleRepository.findById(user.getRoleId())
                .orElseThrow(RoleNotFoundException::new);
        userEntity.setRole( roleEntity );

        return userEntity;
    }

    @Override
    public UserEntity toEntityUser(UserRequest userRequest) {

        if(userRequest == null){
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setIdentification(userRequest.getIdentification());
        userEntity.setPhone(userRequest.getPhone());
        userEntity.setDateOfBirth(userRequest.getDateOfBirth());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        RoleEntity roleEntity = roleRepository.findById(userRequest.getRoleId())
                .orElseThrow(RoleNotFoundException::new);
        userEntity.setRole(roleEntity);
        return userEntity;
    }

    @Override
    public UserResponse toUserResponse(UserEntity userEntity) {

        if ( userEntity == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setName(userEntity.getName());
        userResponse.setLastName(userEntity.getLastName());
        userResponse.setIdentification(userEntity.getIdentification());
        userResponse.setPhone(userEntity.getPhone());
        userResponse.setDateOfBirth(userEntity.getDateOfBirth());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setPassword(userEntity.getPassword());
        userResponse.setRole(roleEntityMapper.toRole(userEntity.getRole()));

        return userResponse;
    }
}
