package com.example.ecommerce_api.Models.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CartDTO {
    private Long id;
    private List<CartItemDTO> cartItems;

    public CartDTO(Long id, List<CartItemDTO> cartItemsResponse){
        this.id = id;
        cartItems = cartItemsResponse;
    }
}
