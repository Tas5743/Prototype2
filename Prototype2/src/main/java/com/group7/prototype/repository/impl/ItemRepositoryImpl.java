package com.group7.prototype.repository.impl;

import com.group7.prototype.model.Item;
import com.group7.prototype.repository.ItemRepository;
import org.springframework.stereotype.Repository;
import com.google.common.collect.MoreCollectors;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private  List<Item> itemList = new ArrayList<>();

    @Override
    public List<Item> findAllItems() {
        return itemList;
    }

    @Override
    public Item addItem(Item item) {
        itemList.add(item);
        return item;
    }

    @Override
    public Item findItemByBarcode(int barcode) {
        return itemList.stream().filter(g -> g.getBarcode() == barcode).collect(MoreCollectors.onlyElement());
    }

    @Override
    public Item editItem(Integer barcode, String name, Integer quantity, Integer lQuantity, Double price) {
        Item foundItem = findItemByBarcode(barcode);
        if (foundItem != null){
            foundItem.setName(name);
            foundItem.setQuantity(quantity);
            foundItem.setlQuantity(lQuantity);
            foundItem.setPrice(price);
        }
        return foundItem;
    }

    @Override
    public boolean deleteItem(int barcode) {
        Item foundItem = findItemByBarcode(barcode);
        if (foundItem != null) {
            return itemList.remove(foundItem);
        }
        return false;
    }
}
