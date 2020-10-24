package com.group7.prototype.repository;

import com.group7.prototype.model.Item;

import java.util.List;

public interface ItemRepository {

    List<Item> findAllItems();

    Item addItem(Item item);

    Item findItemByBarcode(int barcode);

    Item editItem(Integer barcode, String name, Integer quantity, Integer lQuantity, String price);

    boolean deleteItem(int barcode);
}
