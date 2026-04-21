package com.ijse.foodsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.foodsystem.entity.FoodItem;
import com.ijse.foodsystem.repository.FoodRepository;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public FoodItem createFood(FoodItem foodItem) {
        return foodRepository.save(foodItem);
    }

    public List<FoodItem> getAllFoods() {
        return foodRepository.findAll();
    }

    public FoodItem getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found!"));
    }

    public List<FoodItem> getFoodsByCategory(Long categoryId) {
        return foodRepository.findByCategoryId(categoryId);
    }

    public FoodItem updateFood(Long id, FoodItem foodItem) {
        FoodItem existing = getFoodById(id);
        existing.setName(foodItem.getName());
        existing.setDescription(foodItem.getDescription());
        existing.setPrice(foodItem.getPrice());
        existing.setStatus(foodItem.getStatus());
        existing.setCategory(foodItem.getCategory());
        return foodRepository.save(existing);
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}