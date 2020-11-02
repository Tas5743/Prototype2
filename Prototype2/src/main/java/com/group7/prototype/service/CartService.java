package com.group7.prototype.service;

import com.group7.prototype.model.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findAllCartItems();

    Cart addToCart(Cart Cart);

    Cart findCartItemByName(String name);

    Cart editCart(String name, Integer quantity);

    boolean deleteCartItem(String name);

    String calculateTotal();

    boolean clearCart();

}
