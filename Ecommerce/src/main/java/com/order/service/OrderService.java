package com.order.service;

import com.cart.entity.CartItem;
import com.order.entiry.Order;
import com.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    PaymentService paymentService;
    @Autowired
    OrderRepository orderRepository;

    public Order placeOrder(List<CartItem> cartItems) {
        Double totalPrice = 0d;
        for (CartItem cartItem : cartItems) {
            totalPrice += cartItem.getProductPrice();
        }

        // this will make payment and give status
        String paymentResponse = paymentService.makePayment(totalPrice);

        // this will save order status in db
        return orderRepository.save(new Order(cartItems, paymentResponse));
    }
}
