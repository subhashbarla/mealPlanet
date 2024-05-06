package com.mealplanet.foodplatform;

import com.mealplanet.foodplatform.model.OrderItem;
import com.mealplanet.foodplatform.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

    @Test
    public void testCalculateTotalRevenue() {
        OrderService orderService = new OrderService();
        OrderItem orderItem1 = new OrderItem(1L, "Pizza", 10.0, 2);
        OrderItem orderItem2 = new OrderItem(2L, "Burger", 5.0, 3);
        orderService.addOrderItem(orderItem1,1L,  1L);
        orderService.addOrderItem(orderItem2,1L,  1L);

        double expectedRevenue = (10.0 * 2 + 5.0 * 3) * 0.12;
        assertEquals(Math.ceil(expectedRevenue), Math.ceil(orderService.calculateTotalRevenueFromEachRestaurant(1L)));
    }
}
