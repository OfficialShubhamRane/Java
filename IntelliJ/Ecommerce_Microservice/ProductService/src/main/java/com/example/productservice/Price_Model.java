package com.example.productservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price_Model {

    private Long prodId;
    private String prodName;
    private Long originalPrice;
    private Long discountedPrice;

}
