package com.ijse.foodsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.foodsystem.entity.Payment;
import com.ijse.foodsystem.service.PaymentService;

/**
 * PaymentController handles payment processing for orders.
 * Accessible by authenticated users.
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * Processes a payment for a specific order.
     * POST /api/payment/{orderId}?amount=500.00
     */
    @PostMapping("/{orderId}")
    public ResponseEntity<Payment> makePayment(@PathVariable Long orderId,
                                                @RequestParam Double amount) {
        return ResponseEntity.ok(paymentService.makePayment(orderId, amount));
    }

    /**
     * Returns payment details for a specific order.
     * GET /api/payment/{orderId}
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long orderId) {
        return ResponseEntity.ok(paymentService.getPaymentByOrderId(orderId));
    }
}