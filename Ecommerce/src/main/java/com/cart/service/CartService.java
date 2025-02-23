package com.cart.service;

import com.user.User;
import com.cart.entity.Cart;
import com.cart.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

      public Cart addProductToCart(CartItem cartItem, User user){
          Cart cart = new Cart(user.getId(),Arrays.asList(cartItem));
          Cart savedCart = cartRepository.save(cart);
          return savedCart;
      }

    public Cart updateCart(String id, User user, CartItem cartItem) {
          Optional<Cart> savedCart = cartRepository.findById(id);

        // This will update cart
        Cart cart = savedCart.get();
        List<CartItem> cartItems = cart.getCartItems();
        cartItems.add(cartItem);

        Cart updatedCart = cartRepository.save(cart);
        return updatedCart;
    }
}
