package com.example.wavedemo.controller;

import com.example.wavedemo.model.POS;
import com.example.wavedemo.services.POSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@Api(value="onlinestore", description="Operations pertaining to POS ")
public class POSController {
    @Autowired
    POSService posService;

    @RequestMapping("/stores/{storeId}/poses")
    @ApiOperation(value = "View a list of available poses",response = List.class)
    public List<POS> posses(@PathVariable(value = "storeId") int storeId){
        System.out.println("getAll poses in sore with id= " + storeId);
        return posService.getAll(storeId);
    }

    @RequestMapping("/stores/{storeId}/poses/{posId}")
    @ApiOperation(value = "Search an POS with an ID", response = POS.class)
    public POS show(@PathVariable(value = "storeId") int storeId, @PathVariable(value = "posId") int posId){
        System.out.println("Store id = " + storeId + "posId = " + posId);
        return posService.getById(storeId, posId);
    }

    @PostMapping("/stores/{storeId}/poses")
    @ApiOperation(value = "Add a pos")
    public void add(@PathVariable(value = "storeId") int storeId, @RequestBody POS pos, HttpServletResponse response){
        System.out.println("create a pos in  store with storeId = " + storeId);
        insert(storeId, pos, response);
        posService.create(storeId, pos);
    }

    private void insert(@PathVariable(value = "storeId") int storeId, @RequestBody POS pos, HttpServletResponse response) {
        //TODO        validate();
        if(storeId!=pos.getStoreId()) {
            try {
                System.out.println("storeId's unmatch! storeId = " + storeId + ", pos.storeId= " + pos.getStoreId());
                response.sendError(HttpStatus.BAD_REQUEST.value());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value="/stores/{storeId}/poses/{posId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a POS with an ID",response = POS.class)
    public void delete(@PathVariable(value = "storeId") int storeId, @PathVariable(value = "posId") int posId){
        System.out.println("deleting in Store id = " + storeId + " posId = " + posId);
        posService.removeById(posId);
    }

    @PutMapping("/stores/{storeId}/poses")
    @ApiOperation(value = "Add a pos")
    public void update(@PathVariable(value = "storeId") int storeId, @RequestBody POS pos, HttpServletResponse response) {
        System.out.println("Update a pos in  store with storeId = " + storeId);
        insert(storeId, pos, response);
        posService.create(storeId, pos);
    }

}
