package com.example.ecommerce_api.Models.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String product_name;
    private float product_price;

    public ProductDTO(Long id, String product_name, float product_price){
        this.id = id;
        this.product_name = product_name;
        this.product_price = product_price;
    }
}
