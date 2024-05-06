package com.mealplanet.foodplatform.service;

import com.mealplanet.foodplatform.model.Order;
import com.mealplanet.foodplatform.model.OrderItem;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {
    private final Map<Long, Map<Long, Order>> orders = new ConcurrentHashMap<>();
    //mapOfRestaurantId TO Each Customer's OrderMap, i.e Map of OrderId to Customer Order

    public OrderItem addOrderItem(OrderItem orderItem,Long orderId,  Long restaurantId) {
        Order order = new Order();
        order.setId(orderId);
        Map<Long, Order> restaurantFirstOrder = orders.computeIfAbsent(restaurantId, k -> {
            Map<Long, Order> firstOrder = new HashMap<>();
            firstOrder.put(orderId, order);
            return firstOrder;
        });
        restaurantFirstOrder.putIfAbsent(orderId, order);
        Order currentOrder = restaurantFirstOrder.get(orderId);
//        if(order==null){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
//        }
        currentOrder.addItem(orderItem);
        int size = currentOrder.getItems().size();
        return currentOrder.getItems().get(size-1);
    }

    public void removeOrderItem(Long itemId, Long restaurantId, Long orderId) {
        Map<Long, Order> mapOfRestIdToEachOrder = orders.get(restaurantId);
        Order currentOrder = mapOfRestIdToEachOrder.get(orderId);
        if (currentOrder == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
        currentOrder.removeItem(itemId);
    }

    public double calculateTotalRevenueFromEachRestaurant(Long restaurantId) {
        Map<Long, Order> mapOfRestIdToEachOrder = orders.get(restaurantId);
        if (mapOfRestIdToEachOrder == null) {
            return 0.0;
        }
//        return order.calculateTotalRevenue();
        return mapOfRestIdToEachOrder.values().stream().mapToDouble(Order::calculateTotalRevenue).sum();

    }

    public double calculateTotalRevenueOfAllRestaurant() {
        return orders.values().stream().flatMap(map->map.values().stream()).mapToDouble(Order::calculateTotalRevenue).sum();

    }

    public Order getOrderSummary(Long restaurantId, Long orderId) {
        Map<Long, Order> mapOfRestIdToEachOrder = orders.getOrDefault(restaurantId,new HashMap<>());
        Order order = mapOfRestIdToEachOrder.getOrDefault(orderId, new Order());
        return order;
    }
}
