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

    public List<Cart> findAllCartItems() {
        return this.cartList;
    }

    public Cart addToCart(Cart cart) {
        this.cartList.add(cart);
        return cart;
    }


    public Integer findNextCartId() {
        Integer maxValue = 0;
        for (Cart cart : cartList) {
            if (cart.getIndex() != null && cart.getIndex() > maxValue) {
                maxValue =cart.getIndex();
            }
        }
        return maxValue + 1;
    }

    public Cart createCartItem(String itemName, Double itemPrice, int quantity) {
        int index = findNextCartId();
        return new Cart(index,itemName, itemPrice, quantity);
    }

    public Cart findCartItemByIndex(int index) {
        return this.cartList.stream().filter((g) -> g.getIndex().equals(index)).collect(MoreCollectors.onlyElement());
    }

    public Cart editCart(Integer index, Integer quantity) {
        Cart foundCart = this.findCartItemByIndex(index);
        if (foundCart != null) {
            foundCart.setQuantity(quantity);
        }
        return foundCart;
    }

    public boolean deleteCartItem(int index) {
        Cart foundCart = this.findCartItemByIndex(index);
        return foundCart != null && this.cartList.remove(foundCart);
    }
}
