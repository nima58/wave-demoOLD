package com.example.wavedemo.services;

import com.example.wavedemo.model.POS;
import com.example.wavedemo.repositories.POSRepositoryMockImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POSService implements BaseService<POS>{

    @Autowired
    POSRepositoryMockImpl mock;

    @Override
    public List<POS> getAll() {
        return mock.all();
    }

    public List<POS> getAll(int storeId) {
        return mock.all(storeId);
    }

    @Override
    public POS getById(int id) {
        return mock.byId(id);
    }

    public POS getById(int storeId, int posId) {
        return mock.byId(storeId, posId);
    }

    @Override
    public void create(POS pos) {
        mock.create(pos);
    }

    public void create(int storeId, POS pos) {
        mock.create(storeId, pos);
    }

    public void put(int storeId, POS pos) {
        mock.create(storeId, pos);
    }

    @Override
    public void removeById(int id) {
        mock.removeById(id);
    }
}
