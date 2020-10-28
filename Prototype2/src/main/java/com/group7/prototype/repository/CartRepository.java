package com.group7.prototype.repository;

import com.group7.prototype.model.Cart;

import java.util.List;

public interface CartRepository {

    List<Cart> findAllCartItems();

    Cart addToCart(Cart Cart);

    Cart createCartItem(String itemName, String itemPrice, int quantity);

    Cart findCartItemByName(String name);

    Cart editCart(String name, Integer quantity, String price);

    boolean deleteCartItem(String name);

}
