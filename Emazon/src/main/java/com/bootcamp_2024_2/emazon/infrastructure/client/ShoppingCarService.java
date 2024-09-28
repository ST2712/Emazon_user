package com.bootcamp_2024_2.emazon.infrastructure.client;

import com.bootcamp_2024_2.emazon.application.dto.request.ShoppingCarRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.ShoppingCarResponse;
import com.bootcamp_2024_2.emazon.infrastructure.configuration.security.JwtService;
import com.bootcamp_2024_2.emazon.infrastructure.exception.UserNotFoundException;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.entity.UserEntity;
import com.bootcamp_2024_2.emazon.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCarService {

    private final ShoppingCartFeignClient feignClient;
    private final JwtService jwtService;
    private final IUserRepository userRepository;

    public ShoppingCarResponse getShoppingCarById (Long id) {
        return feignClient.getShoppingCarById(id);
    }

    public ShoppingCarResponse saveShoppingCar(String token, ShoppingCarRequest request) {
        UserEntity user = userRepository.findByEmail(jwtService.extractUsername(token))
                .orElseThrow(UserNotFoundException::new);
        Long userId = user.getId();
        request.setUserId(userId);
        return feignClient.saveShoppingCart(request);
    }
}
