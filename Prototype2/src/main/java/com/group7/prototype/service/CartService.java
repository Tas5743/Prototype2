package com.group7.prototype.service;

import com.group7.prototype.model.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findAllCartItems();

    Cart addToCart(Cart Cart);

    Cart findCartItemByIndex(int index);

    Cart editCart(int index, Integer quantity);

    boolean deleteCartItem(int index);

    String calculateTotal();

    boolean clearCart();

    Cart createCartItem(String itemName, Double itemPrice, int quantity);

}
