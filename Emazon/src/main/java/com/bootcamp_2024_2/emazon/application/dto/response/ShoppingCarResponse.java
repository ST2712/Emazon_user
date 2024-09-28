package com.bootcamp_2024_2.emazon.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShoppingCarResponse {
    private long id;
    private long articleId;
    private long userId;
    private int quantity;
    private LocalDateTime updateDate;
    private LocalDateTime creationDate;

}
