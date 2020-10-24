package com.group7.prototype.service.impl;

import com.group7.prototype.model.Item;
import com.group7.prototype.repository.ItemRepository;
import com.group7.prototype.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAllItems();
    }

    @Override
    public Item findItemByBarcode(int barcode) {
        return itemRepository.findItemByBarcode(barcode);
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.addItem(item);
    }

    @Override
    public Item editItem(int barcode, String name, int quantity, int lQuantity, String price) {
        return itemRepository.editItem(barcode, name, quantity, lQuantity, price);
    }

    @Override
    public boolean deleteItemByBarcode(int barcode) {
        return itemRepository.deleteItem(barcode);
    }
}
