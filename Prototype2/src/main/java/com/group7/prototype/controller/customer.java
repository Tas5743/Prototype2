package com.group7.prototype.controller;

import com.group7.prototype.model.Cart;
import com.group7.prototype.model.Item;
import com.group7.prototype.service.CartService;
import com.group7.prototype.service.ItemService;
import com.group7.prototype.service.TransactionService;

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

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/customer/cart")
    public String cart(Model model){
        List<Cart> cartList = this.cartService.findAllCartItems();
        model.addAttribute("cart",cartList);
        model.addAttribute("total",cartService.calculateTotal());
        return "cart";
    }



    @PostMapping("/customer/cart/edit/{index}")
        public String editQuantity(@PathVariable int index, Model model){
        Cart item = cartService.findCartItemByIndex(index);
        if(item!=null){
            model.addAttribute("Quantity",item.getQuantity());
        }
        //TODO Write Method to edit quantity of a cart item, use the name to find the specific cart object in the cart - Rohan
        return "redirect:/customer/cart";
    }

    @GetMapping("/customer/cart/remove/{index}")
        public String removeCartItem(@PathVariable int index){
        cartService.deleteCartItem(index);
        //TODO Write Method to remove item from cart - Rohan
        return "redirect:/customer/cart";
    }
    // TODO this needs its own HTML page - Jacob
    // This isn't meant to  have its own edit page, this suppose to update the quantity of an item in the customer's cart.
    //With that said I tried correcting it only to realize that this would require a n
    @PostMapping(value = "/customer/cart/edit/")
    public String cartEdit(@RequestParam("Name") String Name,
                            @RequestParam("Quantity") int Quantity,
                            @RequestParam("Price") String Price){
        //cartService.editCart(index,Quantity);
        return "redirect:/customer/cart";
    }

    @GetMapping(value  = "/customer/cart/clear")
    public String cartClear(){
        cartService.clearCart();
        return "redirect:/customer/cart";
    }
    @GetMapping(value = "/customer/catalog/view")
    public String viewItem( Model model){
        return "itemInfo";
    }
    @PostMapping(value = "/customer/catalog/view/{barcode}")
    public String viewItemForm(Model model, @PathVariable int barcode){
        Item select = itemService.findItemByBarcode(barcode);
        model.addAttribute("item",select);
        return "itemInfo";
    }



    @GetMapping("/customer/catalog")
    public String catalog(Model model){
        List<Item> itemList = this.itemService.findAllItems();
        model.addAttribute("items",itemList);
        return "catalog";
    }

// Removed @RequestParam("itemName") String itemName, @RequestParam("itemPrice" String itemPrice)- Tyler
    @PostMapping("/customer/catalog/{barcode}")
    public String addItemToCart(Model model,@RequestParam("quant") String quant,@PathVariable int barcode) {
        //@RequestParam("Quantity") int Quantity = 0;
        Item select = itemService.findItemByBarcode(barcode);

        int Quantity;
        if( quant == null || quant.isEmpty() ){
            model.addAttribute("errorMessage", "Item Barcode is required");
            return "redirect:/customer/catalog";
        }
        Quantity = Integer.valueOf(quant);
        Cart item = cartService.createCartItem(select.getName(), select.getPrice(), (int) Quantity);
        cartService.addToCart(item);
        return "redirect:/customer/catalog";
    }

    @GetMapping("/customer/checkout")
    public String checkout(){

        return "checkout";
    }

    @GetMapping("/customer/checkout/payment")
    public String pay(){
        transactionService.addTransaction(transactionService.createTransaction(cartService.findAllCartItems()));
        cartService.clearCart();
        return "redirect:/customer/catalog";
    }



}
