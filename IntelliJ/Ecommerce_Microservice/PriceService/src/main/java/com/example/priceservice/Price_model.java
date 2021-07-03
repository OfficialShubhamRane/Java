package com.example.priceservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price_model {

    private Long prodId;
    private String prodName;
    private Long originalPrice;
    private Long discountedPrice;

}
