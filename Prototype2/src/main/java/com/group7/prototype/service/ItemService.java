package com.group7.prototype.service;

import com.group7.prototype.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAllItems();

    Item findItemByBarcode(int barcode);

    Item addItem(Item item);

    Item editItem(Integer barcode, String name, Integer quantity, Integer lQuantity, String price, String iInfo, String IDesc, String imageRef);

    boolean deleteItemByBarcode(int barcode);

    List<Item> findAllFilteredItemsName(String filter);



}
