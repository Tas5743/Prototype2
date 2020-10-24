package com.group7.prototype.controller;

import com.group7.prototype.model.Item;
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

    @GetMapping("/customer/cart")
    public String ABV(Model model){
        List<Item> itemList = this.itemService.findAllItems();
        model.addAttribute("items",itemList);
        return "cart";
    }
}
