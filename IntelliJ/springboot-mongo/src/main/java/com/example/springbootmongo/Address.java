package com.example.springbootmongo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String postalCode;
    private String city;

}
