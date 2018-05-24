package com.example.wavedemo.services;

import com.example.wavedemo.model.Store;
import com.example.wavedemo.repositories.StoreRepositoryMockImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoresService implements BaseService<Store>{

    @Autowired
    StoreRepositoryMockImpl mock;

    @Override
    public List<Store> getAll() {
        return mock.all();
    }

    @Override
    public Store getById(int id) {
        return mock.byId(id);
    }

    @Override
    public void create(Store store) {
        mock.create(store);
    }

    @Override
    public void removeById(int id) {
        mock.removeById(id);
    }
}
