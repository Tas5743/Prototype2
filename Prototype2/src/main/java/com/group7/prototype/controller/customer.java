package com.group7.prototype.controller;

import com.group7.prototype.model.Cart;
import com.group7.prototype.model.Item;
import com.group7.prototype.service.CartService;
import com.group7.prototype.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class customer {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CartService cartService;

    @GetMapping("/customer/cart")
    public String cart(Model model){
        List<Cart> cartList = this.cartService.findAllCartItems();
        model.addAttribute("cart",cartList);
        model.addAttribute("total",cartService.calculateTotal());
        return "cart";
    }

    @PostMapping("/customer/cart/edit{name}")
        public String editQuantity(@PathVariable String name, Model model){
        Cart item = cartService.findCartItemByName(name);
        if(item!=null){
            model.addAttribute("Quantity",item.getQuantity());
        }
        //TODO Write Method to edit quantity of a cart item, use the name to find the specific cart object in the cart - Rohan
        return "redirect:/customer/cart";
    }

    @PostMapping("/customer/cart/remove{name}")
        public String removeCartItem(@PathVariable String name, Model model){
        cartService.deleteCartItem(name);
        //TODO Write Method to remove item from cart - Rohan
        return "redirect:/customer/cart";
    }
    @PostMapping(value  = "/customer/cart/edit")
    public String cartEdit(@RequestParam("Name") String Name,
                            @RequestParam("Quantity") int Quantity,
                            @RequestParam("Price") String Price){
        cartService.editCart(Name,Quantity,Price);
        return "redirect:/customer/cart";
    }


    @GetMapping("/customer/catalog")
    public String catalog(Model model){
        List<Item> itemList = this.itemService.findAllItems();
        model.addAttribute("items",itemList);
        return "catalog";
    }

    @PostMapping("/customer/catalog/{barcode}")
    public String addItemToCart(@RequestParam("itemName") String itemName, @RequestParam("itemPrice") String itemPrice){
        //TODO Add method to take the name and price of an item, and create a cart object with quantity 1. - Kevin
        //@RequestParam("Quantity") int Quantity = 0;
        int Quantity = 0;
        Cart item = cartService.createCartItem(itemName, itemPrice, Quantity);
        return "redirect:/customer/catalog";
    }

    @GetMapping("/customer/checkout")
    public String checkoout(Model model){
        return "checkout";
    }



}
