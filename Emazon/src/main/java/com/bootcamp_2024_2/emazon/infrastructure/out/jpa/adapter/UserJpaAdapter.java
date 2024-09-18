package com.bootcamp_2024_2.emazon.infrastructure.out.jpa.adapter;

import com.bootcamp_2024_2.emazon.domain.model.User;
import com.bootcamp_2024_2.emazon.domain.spi.IUserPersistencePort;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.UserEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        return userOptional.map(userEntityMapper::toUser);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntityUser(user));
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userEntityMapper.toUser(savedUserEntity);
    }
}
