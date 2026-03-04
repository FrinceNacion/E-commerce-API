package com.example.ecommerce_api.Models.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CartDTO {
    private Integer id;
    private List<CartItemDTO> cart_items_list;

    public CartDTO(Integer id, List<CartItemDTO> cart_items_response){
        this.id = id;
        cart_items_list = cart_items_response;
    }
}
