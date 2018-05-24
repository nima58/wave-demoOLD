package com.example.wavedemo.repositories;

import com.example.wavedemo.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemRepositoryMockImpl implements BaseRepository<Item> {
    List<Item> items;
    ItemRepositoryMockImpl(){
        init();
    }
    @Override
    public List<Item> all() {
        return items;
    }

    @Override
    public Item byId(int id) {
        return items.get(id);
    }

    @Override
    public void create(Item item) {
        items.add(item);
    }

    @Override
    public void removeById(int id) {
        Item item = items.get(id);
        if(item !=null)
            items.remove(item);
    }

    public void init() {
        items = new ArrayList<>();
        Item item = new Item();
        item.setPosId(0);
        item.setName("Cola Zero");
        item.setPrice(20);
        items.add(item);

        item = new Item();
        item.setPosId(1);
        item.setName("Pepsi Max");
        item.setPrice(22);
        items.add(item);

        item = new Item();
        item.setPosId(2);
        item.setName("Fanta");
        item.setPrice(23);
        items.add(item);
    }


}
