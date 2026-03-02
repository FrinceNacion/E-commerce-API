package com.example.ecommerce_api.Models.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String productName;
    private float productPrice;

    public ProductDTO(Long id, String productName, float productPrice){
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
