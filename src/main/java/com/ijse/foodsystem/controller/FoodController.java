package com.ijse.foodsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.foodsystem.entity.FoodItem;
import com.ijse.foodsystem.service.FoodService;

/**
 * FoodController handles CRUD operations for food items.
 * Accessible by ADMIN role only.
 */
@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    /**
     * Creates a new food item.
     * POST /api/food
     */
    @PostMapping
    public ResponseEntity<FoodItem> createFood(@RequestBody FoodItem foodItem) {
        return ResponseEntity.ok(foodService.createFood(foodItem));
    }

    /**
     * Returns all food items.
     * GET /api/food
     */
    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllFoods() {
        return ResponseEntity.ok(foodService.getAllFoods());
    }

    /**
     * Returns a food item by ID.
     * GET /api/food/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFoodById(id));
    }

    /**
     * Returns all food items in a specific category.
     * GET /api/food/category/{categoryId}
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<FoodItem>> getFoodsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(foodService.getFoodsByCategory(categoryId));
    }

    /**
     * Updates an existing food item.
     * PUT /api/food/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFood(@PathVariable Long id,
                                                @RequestBody FoodItem foodItem) {
        return ResponseEntity.ok(foodService.updateFood(id, foodItem));
    }

    /**
     * Deletes a food item by ID.
     * DELETE /api/food/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.ok("Food item deleted successfully!");
    }
}