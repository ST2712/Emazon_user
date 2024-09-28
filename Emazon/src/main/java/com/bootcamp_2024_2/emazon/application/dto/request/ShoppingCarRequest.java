package com.bootcamp_2024_2.emazon.application.dto.request;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShoppingCarRequest {

    @Positive(message = "Article id must be positive")
    private long articleId;
    private long userId;
    @PositiveOrZero(message = "Quantity must be positive")
    private int quantity;
    @PastOrPresent(message = "Update date cannot be in the future")
    private LocalDateTime updateDate;
    @PastOrPresent(message = "Creation date cannot be in the future")
    private LocalDateTime creationDate;
}
