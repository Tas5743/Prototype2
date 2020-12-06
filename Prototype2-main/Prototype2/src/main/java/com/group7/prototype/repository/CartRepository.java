package com.group7.prototype.repository;

import com.group7.prototype.model.Cart;

import java.util.List;

public interface CartRepository {

    List<Cart> findAllCartItems();

    Cart addToCart(Cart Cart);

    Cart createCartItem(String itemName, Double itemPrice, int quantity);

    Cart findCartItemByIndex(int index);

    Cart editCart(Integer index, Integer quantity);

    boolean deleteCartItem(int index);

}
