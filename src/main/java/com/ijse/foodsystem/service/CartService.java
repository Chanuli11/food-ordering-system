package com.ijse.foodsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.foodsystem.entity.Cart;
import com.ijse.foodsystem.entity.CartItem;
import com.ijse.foodsystem.entity.FoodItem;
import com.ijse.foodsystem.entity.User;
import com.ijse.foodsystem.repository.CartItemRepository;
import com.ijse.foodsystem.repository.CartRepository;
import com.ijse.foodsystem.repository.FoodRepository;
import com.ijse.foodsystem.repository.UserRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found!"));
    }

    public Cart addItemToCart(Long userId, Long foodId, Integer quantity) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        FoodItem foodItem = foodRepository.findById(foodId)
                .orElseThrow(() -> new RuntimeException("Food item not found!"));

        Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(user);
            return cartRepository.save(newCart);
        });

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setFoodItem(foodItem);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);

        return cartRepository.findById(cart.getId()).orElseThrow();
    }

    public void removeItemFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        cartItemRepository.deleteAll(cart.getCartItems());
    }
}