package com.ijse.foodsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.foodsystem.entity.Order;
import com.ijse.foodsystem.service.OrderService;

/**
 * OrderController handles order placement and management.
 * Accessible by authenticated users.
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Places a new order from the user's cart.
     * POST /api/order/{userId}
     */
    @PostMapping("/{userId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.placeOrder(userId));
    }

    /**
     * Returns all orders for a specific user.
     * GET /api/order/{userId}
     */
    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }

    /**
     * Returns a specific order by ID.
     * GET /api/order/details/{orderId}
     */
    @GetMapping("/details/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    /**
     * Updates the status of an order.
     * PUT /api/order/{orderId}/status?status=DELIVERED
     */
    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long orderId,
                                               @RequestParam String status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
    }
}