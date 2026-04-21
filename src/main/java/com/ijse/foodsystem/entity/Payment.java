package com.ijse.foodsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Payment entity represents a payment made for an order.
 * Each order has one payment with a status.
 */
@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Payment status
    @Enumerated(EnumType.STRING)
    private Status status;

    // Available payment statuses
    public enum Status {
        PENDING, COMPLETED, FAILED
    }

    // Total amount paid
    private Double amount;

    // Date and time of payment
    private LocalDateTime paidAt;

    // Each payment is linked to one order
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}