package com.group7.prototype.repository.impl;

import com.group7.prototype.jpa.jpaItemRepo;
import com.group7.prototype.model.Item;
import com.group7.prototype.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.MoreCollectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    private jpaItemRepo jpaItemRepo;

    @Override
    public List<Item> findAllItems() {
        return (List <Item>) jpaItemRepo.findAll();
    }

    @Override
    public Item addItem(Item item) {
        return jpaItemRepo.save(item);
    }

    @Override
    public Item findItemByBarcode(int barcode) {
        Optional<Item> itemOptional = jpaItemRepo.findById(barcode);
        if (itemOptional.isPresent()){
            return itemOptional.get();
        }
        return null;
    }

    @Override
    public Item editItem(Integer barcode, String name, Integer quantity, Integer lQuantity, String price, String iInfo, String iDesc, String imageRef){
        Item foundItem = findItemByBarcode(barcode);
        if (foundItem != null){
            foundItem.setName(name);
            foundItem.setQuantity(quantity);
            foundItem.setlQuantity(lQuantity);
            foundItem.setPrice(Double.parseDouble(price));
            foundItem.setiInfo(iInfo);
            foundItem.setiDesc(iDesc);
            foundItem.setName(imageRef);
        }

        if (foundItem == null) return null;
        return jpaItemRepo.save(foundItem);
    }

    @Override
    public boolean deleteItem(int barcode) {
        Item foundItem = findItemByBarcode(barcode);
        if (foundItem != null) {
            jpaItemRepo.deleteById(foundItem.getBarcode());
            return true;
        }
        return false;
    }
}
