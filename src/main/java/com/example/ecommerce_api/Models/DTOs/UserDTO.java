package com.example.ecommerce_api.Models.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private CartDTO user_cart;

    public UserDTO(Long id, String username, String email, CartDTO user_cart_response){
        this.id = id;
        this.username = username;
        this.email = email;
        user_cart = user_cart_response;
    }
}
