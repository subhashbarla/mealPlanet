package com.mealplanet.foodplatform.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Long itemId;
    private String itemName;
    private double itemPrice;
    private int quantity;
}
