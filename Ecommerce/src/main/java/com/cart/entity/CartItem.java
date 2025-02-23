package com.cart.entity;

import com.product.entity.Product;


public class CartItem {

    Product product;
    Integer quantity;
    // we can have further meta data related to selected product

    public Double getProductPrice(){
        return this.product.getPrice() * this.quantity;
    }

}
