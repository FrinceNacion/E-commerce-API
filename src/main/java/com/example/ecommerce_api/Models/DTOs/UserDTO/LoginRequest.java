package com.example.ecommerce_api.Models.DTOs.UserDTO;

import lombok.*;

@Getter
@Setter
public class LoginRequest extends UserRequest{
    private String password;
}
