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
public class ManagerController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/manager/items/view")
    public String ABV(Model model){
        List<Item> itemList = this.itemService.findAllItems();
        model.addAttribute("items",itemList);
        return "stockview";
    }

    @GetMapping("/manager/items/add")
    public String addItem(Model model){
        return "addItem";
    }

    @PostMapping("/manager/items/add")
    public String addItemFormSubmit(Model model, @RequestParam("itemBarcode")Integer itemBarcode
            , @RequestParam("itemName") String itemName, @RequestParam("itemQuantity") Integer itemQuantity
            , @RequestParam("itemLQuantity") Integer itemLQuantity, @RequestParam("itemPrice") String itemPrice){

        Double DoubleitemPrice = 0.0;

        if (itemBarcode == null){
            model.addAttribute("errorMessage", "Item Barcode is required");
            return "addItem";
        }

        else if (itemName == null|| itemName.isEmpty()){
            model.addAttribute("errorMessage", "Item Name is required");
            return "addItem";
        }

        else if (itemQuantity == null){
            model.addAttribute("errorMessage", "Item Quantity is required");
            return "addItem";
        }



        else if (itemPrice != null){
            try{
                DoubleitemPrice = Double.valueOf(itemPrice);
            }catch (NumberFormatException nfex){
                model.addAttribute("errorMessage", "Invalid bookprice");
                return "addItem";
            }
        }
        Item item = new Item(itemBarcode,itemName,itemQuantity,itemLQuantity,DoubleitemPrice);
        item = itemService.addItem(item);
        model.addAttribute("success",Boolean.TRUE);
        return "redirect:stockview";
    }

    @GetMapping(value = "/manager/items/edit/{barcode}")
    public String editItemForm(@PathVariable int barcode, Model model){

        Item item = itemService.findItemByBarcode(barcode);
        if (item != null) {
            model.addAttribute("Name", item.getName());
            model.addAttribute("Quantity", item.getQuantity());
            model.addAttribute("lQuantity", item.getlQuantity());
            model.addAttribute("Price", item.getPrice());
            return "editItem";
        }
        else {
            return "redirect:stockview";
        }
    }

    @PostMapping(value  = "/manager/items/edit")
    public String itemEdit(@RequestParam("Barcode") int Barcode,
                           @RequestParam("Name") String Name, @RequestParam("Quantity") int Quantity,
                           @RequestParam("lQuantity") int lQuantity, @RequestParam("Price") Double Price ){
        itemService.editItem(Barcode,Name,Quantity,lQuantity,Price);
        return "redirect:stockview";
    }

    @GetMapping(value = "/manager/items/delete/{barcode}")
    public String deleteItem(@PathVariable int barcode){
        itemService.deleteItemByBarcode(barcode);
        return "redirect:stockview";
    }

}
