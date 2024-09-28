package com.bootcamp_2024_2.emazon.infrastructure.out.jpa.adapter;

import com.bootcamp_2024_2.emazon.domain.model.User;
import com.bootcamp_2024_2.emazon.domain.spi.IUserPersistencePort;
import com.bootcamp_2024_2.emazon.infrastructure.exception.RoleNotFoundException;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.RoleEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.UserEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IRoleRepository;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;

    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        return userOptional.map(userEntityMapper::toUser);
    }

    @Override
    public User save(User user) {
        Optional<RoleEntity> optionalRole = roleRepository.findById(user.getRoleId());
        if(optionalRole.isEmpty()){
            throw new RoleNotFoundException("Role was not found");
        }
        UserEntity userEntity =  userEntityMapper.toEntityUser(user);
        userEntity.setRole(optionalRole.get());
        userEntity.setCarritoIds(new ArrayList<>());
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userEntityMapper.toUser(savedUserEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
        return optionalUser.map(userEntityMapper::toUser);
    }
}
