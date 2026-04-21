package com.ijse.foodsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
 * FoodItem entity represents a food product in the system.
 * Each food item belongs to a Category.
 */
@Entity
@Table(name = "food_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the food item
    private String name;

    // Short description of the food item
    private String description;

    // Price of the food item
    private Double price;

    // Availability status of the food item
    @Enumerated(EnumType.STRING)
    private Status status;

    // Available statuses
    public enum Status {
        AVAILABLE, OUT_OF_STOCK
    }

    // Each food item belongs to one category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}