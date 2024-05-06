package com.mealplanet.foodplatform.controller;
import com.mealplanet.foodplatform.model.Order;
import com.mealplanet.foodplatform.model.OrderItem;
import com.mealplanet.foodplatform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {


    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem orderItem, @RequestParam Long restaurantId, @RequestParam Long orderId) {
        OrderItem orderItem1 = orderService.addOrderItem(orderItem,orderId,  restaurantId);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderItem1);
    }

    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<Void> removeOrderItem(@PathVariable Long itemId, @RequestParam Long restaurantId, @RequestParam Long orderId) {
        orderService.removeOrderItem(itemId, restaurantId, orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/summary")
    public ResponseEntity<Order> getOrderSummary(@RequestParam Long restaurantId, @RequestParam Long orderId) {
        Order orderDetails= orderService.getOrderSummary(restaurantId, orderId);
        return ResponseEntity.ok(orderDetails);
    }
}