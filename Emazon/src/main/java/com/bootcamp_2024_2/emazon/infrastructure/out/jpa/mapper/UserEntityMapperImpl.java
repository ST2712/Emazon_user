package com.bootcamp_2024_2.emazon.infrastructure.out.jpa.mapper;

import com.bootcamp_2024_2.emazon.domain.model.User;
import com.bootcamp_2024_2.emazon.infrastructure.exception.RoleNotFoundException;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.RoleEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.UserEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IRoleRepository;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapperImpl implements UserEntityMapper {

    private final IRoleRepository roleRepository;

    public UserEntityMapperImpl(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
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
        user.setShoppingCarIds( userEntity.getCarritoIds() );

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
        userEntity.setCarritoIds( user.getShoppingCarIds() );

        return userEntity;
    }

}
