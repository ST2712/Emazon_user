package com.bootcamp_2024_2.emazon.infrastructure.client;

import com.bootcamp_2024_2.emazon.application.dto.response.ShoppingCarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCarService {

    private final ShoppingCartFeignClient feignClient;

    public ShoppingCarResponse getShoppingCarById (Long id) {
        return feignClient.getShoppingCarById(id);
    }
}
