package com.bootcamp_2024_2.emazon.infrastructure.client;

import com.bootcamp_2024_2.emazon.application.dto.request.ShoppingCarRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.ShoppingCarResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "emazon-shopping-cart", url = "http://localhost:8082", configuration = FeignClientConfig.class)
public interface ShoppingCartFeignClient {

    @GetMapping("shopping_cart/v1/shopping_cart/{id}")
    ShoppingCarResponse getShoppingCarById(@PathVariable("id") Long id);

    @PostMapping("shopping_cart/v1/shopping_cart")
    ShoppingCarResponse saveShoppingCart(ShoppingCarRequest shoppingCarResponse);
}
