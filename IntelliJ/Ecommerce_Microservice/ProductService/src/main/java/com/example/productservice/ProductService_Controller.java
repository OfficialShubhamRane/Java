package com.example.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@RestController
public class ProductService_Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api/v1/productService/{currency}/{productId}")
    public Product_Model getProductInfo(
            @PathVariable() String currency,
            @PathVariable() Long productId){

        System.out.println(productId);
        List<Product_Model> productList = new ArrayList<>();
        populateProductList(productList);

        Price_Model price = restTemplate.getForObject("http://localhost:8082/api/v1/priceService/"+productId, Price_Model.class);
        Inventory_Model inventory = restTemplate.getForObject("http://localhost:8083/api/v1/inventoryService/"+productId, Inventory_Model.class);
        ExchangeRate_Model exchangeRates = restTemplate.getForObject("http://localhost:8084/api/v1/getExchangeRate/"+currency, ExchangeRate_Model.class);

        for(Product_Model product : productList){
            if( product.getProdId().equals(productId) ){
                assert price != null;
                assert inventory != null;
                assert exchangeRates != null;

                return new Product_Model(
                    product.getProdId(),
                    product.getProdName(),
                    product.getProdDesc(),
                    price.getDiscountedPrice() * exchangeRates.getRate(),
                    inventory.isInStock()
                );
            }
        }

        return null;
    }

    private void populateProductList(List<Product_Model> productList) {
        productList.add(new Product_Model(101L, "iPhone", "Very expensive", 0L, false));
        productList.add(new Product_Model(102L, "Gaming mouse", "Nice to have",0L,false));
        productList.add(new Product_Model(103L, "Washing machine", "Must need",0L,false));
    }
}
