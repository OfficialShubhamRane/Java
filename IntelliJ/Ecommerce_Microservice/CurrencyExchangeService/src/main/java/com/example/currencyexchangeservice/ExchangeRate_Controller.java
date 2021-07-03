package com.example.currencyexchangeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExchangeRate_Controller {

    @GetMapping("api/v1/getExchangeRate/{currencyID}")
    public ExchangeRate_Model getExchangeRate( @PathVariable String currencyID){
        List<ExchangeRate_Model> exchangeRateList = new ArrayList<>();
        populateExchangeRate(exchangeRateList);

        for (ExchangeRate_Model exchangeRate_model : exchangeRateList){
            if(exchangeRate_model.getCurrency().equals(currencyID)){
                return exchangeRate_model;
            }
        }

        return null;

    }

    private void populateExchangeRate(List<ExchangeRate_Model> exchangeRateList) {

        exchangeRateList.add(new ExchangeRate_Model("yen",3L));
        exchangeRateList.add(new ExchangeRate_Model("inr",79L));
        exchangeRateList.add(new ExchangeRate_Model("rub",9L));

    }

}
