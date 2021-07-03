package com.example.currencyexchangeservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate_Model {

    private String currency;
    private Long rate;
}
