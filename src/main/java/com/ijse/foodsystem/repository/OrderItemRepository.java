package com.ijse.foodsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.foodsystem.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}