package com.example.wavedemo.controller;

import com.example.wavedemo.model.Store;
import com.example.wavedemo.services.StoresService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value="onlinestore", description="Operations pertaining to store in Online Store")
public class StoresController implements ControllerApi<Store>{

    @Autowired
    StoresService storesService;

    @Override
    @RequestMapping("/stores")
    @ApiOperation(value = "View a list of available Stores",response = List.class)
    public List<Store> list() {
        return storesService.getAll();
    }

    @Override
    @RequestMapping("/stores/{id}")
    @ApiOperation(value = "Search a store with an ID", response = Store.class)
    public Store show(@PathVariable(value = "id") int id) {
        System.out.println("Store show id = " + id);
        return storesService.getById(id);
    }

    @Override
    @DeleteMapping("/stores/{id}")
    @ApiOperation(value = "Delete a store with an ID",response = Store.class)
    public void delete(@PathVariable(value = "id") int id) {
        storesService.removeById(id);
    }

    @Override
    @PostMapping("/stores")
    @ApiOperation(value = "Add a store")
    public void create(@RequestBody Store store) {
        storesService.create(store);
    }

    @Override
    public void update(@RequestBody Store store) {
        //TODO
    }

    @Override
    public void patch(Map<Object, Object> attrs) {
        //TODO
    }
}
