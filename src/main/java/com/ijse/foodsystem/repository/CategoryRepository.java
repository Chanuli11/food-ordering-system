package com.ijse.foodsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.foodsystem.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}