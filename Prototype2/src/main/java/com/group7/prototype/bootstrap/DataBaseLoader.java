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
        this.itemRepository.addItem(i1);


    }
}
