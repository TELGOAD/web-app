package com.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String makePayment(Double totalPrice) {
        //here we can write code to integrate a third party payment gateway
        // and respond to user as per payment gateway SUCCESS/FAILED.
        //I am adding SUCCESS for now
        return "SUCCESS";
    }

}
