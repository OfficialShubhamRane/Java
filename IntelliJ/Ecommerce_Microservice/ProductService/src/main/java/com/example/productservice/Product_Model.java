package com.example.productservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_Model {

    private Long prodId;
    private String prodName;
    private String prodDesc;
    private Long price;
    private Boolean inStock;

}
