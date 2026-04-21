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
 * CartItem entity represents a single food item inside a cart.
 * It links a Cart with a FoodItem and stores the quantity.
 */
@Entity
@Table(name = "cart_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Number of units of this food item
    private Integer quantity;

    // Each cart item belongs to one cart
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Each cart item refers to one food item
    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;
}