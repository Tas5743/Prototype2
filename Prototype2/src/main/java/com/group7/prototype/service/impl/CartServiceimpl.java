package com.group7.prototype.service.impl;

import com.group7.prototype.model.Cart;
import com.group7.prototype.repository.CartRepository;
import com.group7.prototype.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class CartServiceimpl implements CartService {


    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAllCartItems() {
        return cartRepository.findAllCartItems();
    }


    @Override
    public Cart addToCart(Cart cart) {
        return cartRepository.addToCart(cart);
    }


    @Override
    public Cart findCartItemByName(String name) {
        return cartRepository.findCartItemByName(name);
    }

    @Override
    public Cart editCart(String name, Integer quantity) {
        return cartRepository.editCart(name, quantity);
    }

    @Override
    public boolean deleteCartItem(String name) {
        return cartRepository.deleteCartItem(name);
    }

    @Override
    public String calculateTotal() {
        double total = 0.0;
        List<Cart> cartList = cartRepository.findAllCartItems();
        for (Cart cart : cartList) total = cart.getPrice() * cart.getQuantity();
        return new DecimalFormat("$#.###").format(total);
    }

    @Override
    public boolean clearCart() {
        //return cartRepository.cartList.clear();
        //return cartRepository.findAllCartItems().clear(); You cant return a void value
        cartRepository.findAllCartItems().clear();
        return true;
    }

}
