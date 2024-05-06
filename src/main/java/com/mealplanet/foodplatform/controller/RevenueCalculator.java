package com.mealplanet.foodplatform.controller;

import com.mealplanet.foodplatform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revenue")
public class RevenueCalculator {

    @Autowired
    private final OrderService orderService;

    public RevenueCalculator(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{restId}")
    public ResponseEntity<Double> getRevenueByRestaurantId(@PathVariable("restId") Long restaurantId) {
        double totalRevenue = orderService.calculateTotalRevenueFromEachRestaurant(restaurantId);
        return ResponseEntity.ok(totalRevenue);
    }

    @GetMapping("/all")
    public ResponseEntity<Double> getRevenueFromAllRestaurant() {
        double totalRevenue = orderService.calculateTotalRevenueOfAllRestaurant();
        return ResponseEntity.ok(totalRevenue);
    }
}