package com.example.wavedemo.services;

import java.util.List;

public interface BaseService<T> {

    public List<T> getAll();
    public T getById(int id);

    public void create(T item);

    public void removeById(int id);
}
