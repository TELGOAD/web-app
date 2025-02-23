package com.cart.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "cart")
public class Cart {

    @Id
    private String id;
    private String userId;
    List<CartItem> cartItems;

    public Cart(String userId, List<CartItem> cartItems) {
        this.userId = userId;
        this.cartItems = cartItems;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
