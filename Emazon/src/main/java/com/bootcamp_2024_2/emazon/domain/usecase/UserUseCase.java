package com.bootcamp_2024_2.emazon.domain.usecase;

import com.bootcamp_2024_2.emazon.domain.api.IUserServicePort;
import com.bootcamp_2024_2.emazon.domain.model.User;
import com.bootcamp_2024_2.emazon.domain.spi.IUserPersistencePort;
import com.bootcamp_2024_2.emazon.infrastructure.exception.AgeNotAllowedException;
import com.bootcamp_2024_2.emazon.infrastructure.exception.UserNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.Period;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User findById(Long id) {
        return userPersistencePort.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User save(User user) {
        if(!checkAge(user)) {
            throw new AgeNotAllowedException("User must be at least 18 years old");
        }
        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userPersistencePort.save(user);
    }

    private boolean checkAge(User user) {
        LocalDate dateOfBirth = user.getDateOfBirth();
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();
        return age >= 18;
    }
}
