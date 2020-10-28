package com.group7.prototype.bootstrap;

import com.group7.prototype.model.Item;
import com.group7.prototype.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // Item data
        Item i1 = new Item(67,"100% Orange Juice", 10, 1, 4.99);
        Item i2 = new Item(189,"CocaCola", 15, 5, 3.99);
        Item i3 = new Item(15,"ManillaWafers", 5, 1, 5.99);
        Item i4 = new Item(2109,"TurkeySandwich", 12, 3, 6.99);
        Item i5 = new Item(1523,"FriedChicken", 3, 1, 9.99);
        this.itemRepository.addItem(i1);
        this.itemRepository.addItem(i2);
        this.itemRepository.addItem(i3);
        this.itemRepository.addItem(i4);
        this.itemRepository.addItem(i5);


    }
}
