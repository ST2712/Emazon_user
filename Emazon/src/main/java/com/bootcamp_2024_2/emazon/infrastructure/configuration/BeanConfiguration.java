package com.bootcamp_2024_2.emazon.infrastructure.configuration;

import com.bootcamp_2024_2.emazon.domain.api.IRoleServicePort;
import com.bootcamp_2024_2.emazon.domain.api.IUserServicePort;
import com.bootcamp_2024_2.emazon.domain.spi.IRolePersistencePort;
import com.bootcamp_2024_2.emazon.domain.spi.IUserPersistencePort;
import com.bootcamp_2024_2.emazon.domain.usecase.RoleUseCase;
import com.bootcamp_2024_2.emazon.domain.usecase.UserUseCase;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.adapter.RoleJpaAdapter;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper.RoleEntityMapper;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IRoleRepository;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IRoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;


    @Bean
    IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleJpaAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper, roleRepository);
    }
}
