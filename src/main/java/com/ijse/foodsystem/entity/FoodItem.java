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

/**
 * FoodItem entity represents a food product in the system.
 * Each food item belongs to a Category.
 */
@Entity
@Table(name = "food_items")
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

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}