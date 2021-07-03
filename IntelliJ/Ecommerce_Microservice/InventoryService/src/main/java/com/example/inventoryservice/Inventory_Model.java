package com.example.inventoryservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory_Model {

    private Long prodId;
    private String prodName;
    private boolean inStock;

}
