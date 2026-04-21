package com.ijse.foodsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.foodsystem.entity.Cart;
import com.ijse.foodsystem.service.CartService;

/**
 * CartController handles cart operations for customers.
 * Accessible by CUSTOMER role only.
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * Returns the cart for a specific user.
     * GET /api/cart/{userId}
     */
    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    /**
     * Adds a food item to the user's cart.
     * POST /api/cart/{userId}/add?foodId=1&quantity=2
     */
    @PostMapping("/{userId}/add")
    public ResponseEntity<Cart> addItem(@PathVariable Long userId,
                                        @RequestParam Long foodId,
                                        @RequestParam Integer quantity) {
        return ResponseEntity.ok(cartService.addItemToCart(userId, foodId, quantity));
    }

    /**
     * Removes a specific item from the cart.
     * DELETE /api/cart/item/{cartItemId}
     */
    @DeleteMapping("/item/{cartItemId}")
    public ResponseEntity<String> removeItem(@PathVariable Long cartItemId) {
        cartService.removeItemFromCart(cartItemId);
        return ResponseEntity.ok("Item removed from cart!");
    }

    /**
     * Clears all items from the user's cart.
     * DELETE /api/cart/{userId}/clear
     */
    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<String> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared!");
    }
}