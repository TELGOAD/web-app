package com.order.resource;

import com.cart.entity.CartItem;
import com.order.entiry.Order;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderResource {

    @Autowired
    OrderService orderService;

    // This API will place order which internally calls payment gateway to make payment
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody List<CartItem> cartItems){
        try {
            Order order = orderService.placeOrder(cartItems);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
