package com.bootcamp_2024_2.emazon.application.mapper.response;

import com.bootcamp_2024_2.emazon.application.dto.response.UserResponse;
import com.bootcamp_2024_2.emazon.domain.model.Role;
import com.bootcamp_2024_2.emazon.domain.model.User;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.RoleEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IRoleRepository;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapperImpl implements UserResponseMapper {

    private final IRoleRepository roleRepository;

    public UserResponseMapperImpl(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setName( user.getName() );
        userResponse.setLastName( user.getLastName() );
        userResponse.setIdentification( user.getIdentification() );
        userResponse.setPhone( user.getPhone() );
        userResponse.setDateOfBirth( user.getDateOfBirth() );
        userResponse.setEmail( user.getEmail() );
        userResponse.setPassword( user.getPassword() );

        RoleEntity role = roleRepository.findById( user.getRoleId() ).
            orElseThrow( () -> new RuntimeException( "Role not found" ) );

        userResponse.setRoleName( role.getName() );
        return userResponse;
    }
}
