package com.group7.prototype.repository.impl;

import com.group7.prototype.model.Cart;

import com.group7.prototype.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepositoryimpl implements CartRepository {

    private  List<Cart> cartList = new ArrayList<>();

    //TODO Add code to each of these methods, use the ItemRepository as a reference - Kate


    @Override
    public List<Cart> findAllCartItems() {
        return null;
    }

    @Override
    public Cart addToCart(Cart Cart) {
        return null;
    }

    @Override
    public Cart createCartItem(String itemName, String itemPrice, int quantity) {
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
}
