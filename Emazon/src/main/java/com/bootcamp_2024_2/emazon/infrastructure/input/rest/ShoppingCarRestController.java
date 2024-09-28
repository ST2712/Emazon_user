package com.bootcamp_2024_2.emazon.infrastructure.input.rest;

import com.bootcamp_2024_2.emazon.application.dto.response.ShoppingCarResponse;
import com.bootcamp_2024_2.emazon.infrastructure.client.ShoppingCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping_cart")
public class ShoppingCarRestController {

    private final ShoppingCarService shoppingCarService;

    @GetMapping(path = "/v1/shopping_cart/{id}")
    public ShoppingCarResponse getShoppingCarById(@PathVariable Long id) {
        return shoppingCarService.getShoppingCarById(id);
    }
}
