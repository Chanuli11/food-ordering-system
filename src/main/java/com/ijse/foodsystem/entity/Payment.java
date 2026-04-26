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

/**
 * Payment entity represents a payment made for an order.
 * Each order has one payment with a status.
 */
@Entity
@Table(name = "payments")
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

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDateTime getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}