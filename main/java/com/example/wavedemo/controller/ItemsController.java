package com.example.wavedemo.controller;

import com.example.wavedemo.model.Item;
import com.example.wavedemo.services.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="onlinestore", description="Operations pertaining to items in Online Store")
public class ItemsController {

    @Autowired
    ItemService itemServices;

    @RequestMapping("/items")
    @ApiOperation(value = "View a list of available items",response = List.class)
    public List<Item> items(){
        System.out.println("getAll()....");
        return itemServices.getAll();
    }

    @RequestMapping("/items/{id}")
    @ApiOperation(value = "Search an item with an ID", response = Item.class)
    public Item show(@PathVariable(value = "id") int id){
        System.out.println("getItem id = " + id);
        return itemServices.getById(id);
    }


    @PostMapping("/items")
    @ApiOperation(value = "Add an item")
    public void add(@RequestBody Item item){
        System.out.println("create an item ...");
        itemServices.create(item);
    }

    @RequestMapping(value="/items/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete an item with an ID",response = Item.class)
    public void delete(@PathVariable(value = "id") int id){
        System.out.println("getItem id = " + id);
        itemServices.removeById(id);
    }


}


