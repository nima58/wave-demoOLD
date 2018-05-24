package com.example.wavedemo.services;

import com.example.wavedemo.model.Item;
import com.example.wavedemo.repositories.ItemRepositoryMockImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepositoryMockImpl mock;

    public List<Item> getAll() {
        return mock.all();
    }

    public Item getById(int id) {
        return mock.byId(id);
    }

    public void create(Item item) {
        mock.create(item);
    }

    public void removeById(int id) {
        mock.removeById(id);
    }
}
