//package com.mealplanet.foodplatform.repository;
//
//import com.mealplanet.foodplatform.model.MenuItem;
//import com.mealplanet.foodplatform.model.Order;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface OrderRepository extends JpaRepository<Order, Long> {
//    List<MenuItem> findByOrderId(Long orderId);
//}