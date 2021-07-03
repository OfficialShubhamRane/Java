package com.example.inventoryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Inventory_Controller {

    @GetMapping("api/v1/inventoryService/{productId}")
    public Inventory_Model getInventoryDetails(@PathVariable Long productId){

        List<Inventory_Model> inventoryList = new ArrayList<>();
        populateInventory(inventoryList);

        for( Inventory_Model inventory_model : inventoryList){
            if(inventory_model.getProdId().equals(productId)){
                return inventory_model;
            }
        }

        return null;
    }

    private void populateInventory(List<Inventory_Model> inventoryList) {
        inventoryList.add(new Inventory_Model(101L, "iPhone", true));
        inventoryList.add(new Inventory_Model(102L, "Gaming Mouse", true));
        inventoryList.add(new Inventory_Model(103L, "Washing machine", false));

    }

}
