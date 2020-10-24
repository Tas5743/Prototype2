package com.group7.prototype.service;

import com.group7.prototype.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAllItems();

    Item findItemByBarcode(int barcode);

    Item addItem(Item item);

    Item editItem(int barcode, String name, int quantity, int lQuantity, double price);

    boolean deleteItemByBarcode(int barcode);

}
