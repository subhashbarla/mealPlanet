package com.mealplanet.foodplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id = 0L;
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(Long itemId) {
        items.removeIf(item -> item.getItemId().equals(itemId));
    }

    public double calculateTotalRevenue() {
        return items.stream()
                .mapToDouble(item -> item.getItemPrice() * item.getQuantity() * 0.12) // 12% commission
                .sum();
    }
}
