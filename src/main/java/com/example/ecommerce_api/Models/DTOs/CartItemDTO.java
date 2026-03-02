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
    private ProductDTO productItem;

    public CartItemDTO(Long id, ProductDTO productResponse){
        this.id = id;
        productItem = productResponse;
    }
}
