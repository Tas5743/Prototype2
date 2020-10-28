package com.group7.prototype.service.impl;

import com.group7.prototype.model.Cart;
import com.group7.prototype.repository.CartRepository;
import com.group7.prototype.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Cart addToCart(Cart Cart) {
        return cartRepository.addToCart(Cart);
    }


    @Override
    public Cart findCartItemByName(String name) {
        return cartRepository.findCartItemByName(name);
    }

    @Override
    public Cart editCart(String name, Integer quantity, String price) {
        return cartRepository.editCart(name, quantity, price);
    }

    @Override
    public boolean deleteCartItem(String name) {
        return cartRepository.deleteCartItem(name);
    }

    @Override
    public Double calculateTotal() {
        //TODO: Write Method to calculate total cost of the Cart's contents
        return null;
    }

    @Override
    public boolean clearCart() {
        //return cartRepository.cartList.clear();
        return cartRepository.findAllCartItems().clear();
    }

}
