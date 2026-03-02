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
    private CartDTO userCart;

    public UserDTO(Long id, String username, String email, CartDTO cartResponse){
        this.id = id;
        this.username = username;
        this.email = email;
        userCart = cartResponse;
    }
}
