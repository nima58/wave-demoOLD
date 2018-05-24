package com.example.wavedemo.repositories;

import com.example.wavedemo.model.Store;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreRepositoryMockImpl implements BaseRepository<Store> {

    List<Store> stores;
    public StoreRepositoryMockImpl() {
        init();
    }

    public void init() {
        stores = new ArrayList<>();
        Store store = new Store();
        store.setPosId(0);
        store.setName("ICA Maxi");
        store.setAddress("ICA Storegatan 2, 17231 Sundbyberg");
        store.setPhone("0701234567");
        stores.add(store);

        store = new Store();
        store.setPosId(1);
        store.setName("Hemköp");
        store.setAddress("Regeringsgatan 12, 11111 Sundbyberg");
        store.setPhone("0704532451");
        stores.add(store);

        store = new Store();
        store.setPosId(2);
        store.setName("COOP");
        store.setAddress("Vasagatan 38, 11243 Stockholm");
        store.setPhone("0709876543");
        stores.add(store);

        store = new Store();
        store.setPosId(3);
        store.setName("WILLY's");
        store.setAddress("Solnavägen 21, 17122 Solna");
        store.setPhone("07082930471");
        stores.add(store);
    }

    @Override
    public List<Store> all() {
        return stores;
    }

    @Override
    public Store byId(int id) {
        return stores.get(id);
    }

    @Override
    public void create(Store store) {
        System.out.println("A new store was added name: " + store.getName());
        stores.add(store);
    }

    @Override
    public void removeById(int id) {
        Store store = stores.get(id);
        if(store !=null) {
            stores.remove(store);
            System.out.println("The store with id = " + store.getPosId() + " was removed.");
        }
    }
}
