package com.group7.prototype.repository.impl;

import com.group7.prototype.model.Cart;
import com.group7.prototype.repository.CartRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.google.common.collect.MoreCollectors;

@Repository
public class CartRepositoryimpl implements CartRepository {
    private List<Cart> cartList = new ArrayList();

    public CartRepositoryimpl() {
    }

    public List<Cart> findAllCartItems() {
        return this.cartList;
    }

    public Cart addToCart(Cart cart) {
        this.cartList.add(cart);
        return cart;
    }

    public Cart createCartItem(String itemName, Double itemPrice, int quantity) {
        return new Cart(itemName, itemPrice, quantity);
    }

    public Cart findCartItemByName(String name) {
        return this.cartList.stream().filter((g) -> g.getName() == name).collect(MoreCollectors.onlyElement());
    }

    public Cart editCart(String name, Integer quantity) {
        Cart foundCart = this.findCartItemByName(name);
        if (foundCart != null) {
            foundCart.setQuantity(quantity);
        }
        return foundCart;
    }

    public boolean deleteCartItem(String name) {
        Cart foundCart = this.findCartItemByName(name);
        return foundCart != null && this.cartList.remove(foundCart);
    }
}
