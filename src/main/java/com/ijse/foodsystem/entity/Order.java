package com.ijse.foodsystem.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order entity represents a customer's food order.
 * An order contains multiple order items and has a status.
 */
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Current status of the order
    @Enumerated(EnumType.STRING)
    private Status status;

    // Available order statuses
    public enum Status {
        PLACED, PREPARING, DELIVERED, CANCELLED
    }

    // Date and time when order was created
    private LocalDateTime createdAt;

    // Each order belongs to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // One order has many order items
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}