package com.group7.prototype.service.impl;

import com.group7.prototype.model.Item;
import com.group7.prototype.repository.ItemRepository;
import com.group7.prototype.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Item editItem(Integer barcode, String name, Integer quantity, Integer lQuantity, String price, String iInfo, String IDesc, String imageRef) {
        return itemRepository.editItem(barcode, name, quantity, lQuantity, price,iInfo,IDesc,imageRef);
    }

    @Override
    public boolean deleteItemByBarcode(int barcode) {
        return itemRepository.deleteItem(barcode);
    }

    @Override
    public List<Item> findAllFilteredItemsName(String filter) {
        List<Item> items = itemRepository.findAllItems();
        return items.stream()
                .filter(g -> g.getName().toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
    }
}

