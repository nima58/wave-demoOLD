package com.example.wavedemo.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BaseRepository<T> {
    public List<T> all();
    public T byId(int id);
    public void create(T t);
    public void removeById(int id);
}
