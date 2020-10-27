package com.group7.prototype.service.impl;

import com.group7.prototype.model.Cart;
import com.group7.prototype.repository.CartRepository;
import com.group7.prototype.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceimpl implements CartService {
//TODO Fill in the methods, the first five can be done by simply calling the appropriate CartRepository Method

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAllCartItems() {
        return null;
    }

    @Override
    public Cart addToCart(Cart Cart) {
        return null;
    }


    @Override
    public Cart findCartItemByName(String name) {
        return null;
    }

    @Override
    public Cart editCart(String name, Integer quantity, String price) {
        return null;
    }

    @Override
    public boolean deleteCartItem(String name) {
        return false;
    }

    @Override
    public Double calculateTotal() {
        //TODO: Write Method to calculate total cost of the Cart's contents
        return null;
    }

    @Override
    public boolean clearCart() {
        //TODO: Remove all cart objects from the Cart List
        return false;
    }

}
