package com.ijse.foodsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OrderItem entity represents a single food item inside an order.
 * It stores the quantity and price at the time of ordering.
 */
@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Number of units ordered
    private Integer quantity;

    // Price at the time of ordering
    private Double price;

    // Each order item belongs to one order
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Each order item refers to one food item
    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;
}