package com.ijse.foodsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.foodsystem.entity.FoodItem;

public interface FoodRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findByCategoryId(Long categoryId);
}