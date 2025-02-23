package com.cart.resource;

import com.user.User;
import com.cart.entity.Cart;
import com.cart.entity.CartItem;
import com.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-cart")
public class CartResource {

    @Autowired
    CartService cartService;

    // User can add product to cart using this API
    @PostMapping
    public ResponseEntity<Cart> addProductToCart(@RequestBody CartItem cartItem) {
        try {
            User user = getAuthenticatedUser();
            Cart savedCart = cartService.addProductToCart(cartItem, user);
            return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //This API will update cart by cart item
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") String id, @RequestBody CartItem cartItem) {
        try {
            User user = getAuthenticatedUser();
            Cart updatedCartItem = cartService.updateCart(id,user, cartItem);
            return new ResponseEntity<>(updatedCartItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private User getAuthenticatedUser() {
        User user = new User();
        user.setId("1");
        return user;
    }

}
