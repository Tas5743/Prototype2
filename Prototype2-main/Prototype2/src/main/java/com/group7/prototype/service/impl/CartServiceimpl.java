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
    public Cart findCartItemByIndex(int index) {
        return cartRepository.findCartItemByIndex(index);
    }

    @Override
    public Cart editCart(int index, Integer quantity) {
        return cartRepository.editCart(index, quantity);
    }

    @Override
    public boolean deleteCartItem(int index) {
        return cartRepository.deleteCartItem(index);
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
    @Override
    public Cart createCartItem(String itemName, Double itemPrice, int quantity){return cartRepository.createCartItem(itemName, itemPrice, quantity);}

}
