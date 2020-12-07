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
        Item i1 = new Item(67,"Pudding", 10, 1, 4.99,"Snack Pack Pudding Cups are made with real milk and real sugar. They contain 0g trans fat per serving and are made with no preservatives.","","https://upload.wikimedia.org/wikipedia/commons/5/54/Swiss_MIss_Chocolate_Vanilla_Swirl_pudding_cup.jpg");
        Item i2 = new Item(189,"CocaCola", 15, 5, 3.99,"Contains:CaffeineCarbonated Water, High Fructose Corn Syrup, Caramel Color, Phosphoric Acid, Natural Flavors, Caffeine","","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/15-09-26-RalfR-WLC-0098.jpg/255px-15-09-26-RalfR-WLC-0098.jpg");
        Item i3 = new Item(15,"ManillaWafers", 5, 1, 5.99,"Unbleached Enriched Flour (Wheat Flour, Niacin, Reduced Iron, Thiamine Mononitrate Vitamin B1, Riboflavin Vitamin B2, Folic Acid), Sugar, Canola Oil, Palm Oil, High Fructose Corn Syrup, Whey (From Milk), Eggs, Salt, Leavening (Baking Soda, Calcium Phosphate), Emulsifiers (Mono- And Diglycerides, Soy Lecithin), Artificial Flavor, Natural Flavor.","","https://upload.wikimedia.org/wikipedia/commons/0/01/Nilla-Wafers.jpg");
        Item i4 = new Item(2109,"TurkeySandwich", 12, 3, 6.99,"Turkey Sandwich w/Fries","","https://upload.wikimedia.org/wikipedia/commons/f/f7/Turkey_sandwich_at_a_diner_with_French_Fries.jpg");
        Item i5 = new Item(1523,"FriedChicken", 3, 1, 9.99,"","","https://upload.wikimedia.org/wikipedia/commons/c/c7/Fried_Chicken.jpg");
        this.itemRepository.addItem(i1);
        this.itemRepository.addItem(i2);
        this.itemRepository.addItem(i3);
        this.itemRepository.addItem(i4);
        this.itemRepository.addItem(i5);


    }
}
