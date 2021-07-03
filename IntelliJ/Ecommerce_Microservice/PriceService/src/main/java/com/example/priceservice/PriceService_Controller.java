package com.example.priceservice;

import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PriceService_Controller {

    @GetMapping("/api/v1/priceService/{productId}")
    public Price_model getPriceDetails(@PathVariable Long productId){

        List<Price_model> priceList = new ArrayList<>();
        populatePriceList(priceList);

        for(Price_model price : priceList){
            if(price.getProdId().equals(productId)){
                return price;
            }
        }

        return  null;

    }

    private void populatePriceList(List<Price_model> priceList) {

        priceList.add(new Price_model(101L, "iPhone", 1299L, 999L));
        priceList.add(new Price_model(102L, "Gaming mouse", 99L, 59L));
        priceList.add(new Price_model(103L, "Washing machine", 299L, 199L));

    }

}
