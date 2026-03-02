package com.example.ecommerce_api.Models.DTOs;

import com.example.ecommerce_api.Models.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CartItemDTO {
    private Long id;
    private ProductDTO product_item;

    public CartItemDTO(Long id, ProductDTO product_response){
        this.id = id;
        product_item = product_response;
    }
}
