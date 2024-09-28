package com.bootcamp_2024_2.emazon.infrastructure.input.rest;

import com.bootcamp_2024_2.emazon.application.dto.request.ShoppingCarRequest;
import com.bootcamp_2024_2.emazon.application.dto.response.ShoppingCarResponse;
import com.bootcamp_2024_2.emazon.infrastructure.client.ShoppingCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping_cart")
public class ShoppingCarRestController {

    private final ShoppingCarService shoppingCarService;

    @GetMapping(path = "/v1/shopping_cart/{id}")
    public ShoppingCarResponse getShoppingCarById(@PathVariable Long id) {
        return shoppingCarService.getShoppingCarById(id);
    }

    @PostMapping(path = "/v1/shopping_cart")
    public ShoppingCarResponse saveShoppingCar(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody ShoppingCarRequest request) {

        // Extraer el token del encabezado Authorization
        String token = authorizationHeader.substring(7); // "Bearer " tiene 7 caracteres
        return shoppingCarService.saveShoppingCar(token, request);
    }
}
