package com.order.entiry;

import com.cart.entity.CartItem;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "order")
public class Order {

    @Id
    private String id;
    private List<CartItem> cartItems;
    private String orderStatus;


    public Order(List<CartItem> cartItems,String orderStatus) {
        this.cartItems = cartItems;
        this.orderStatus = orderStatus;
    }
}
