package com.example.ecommerce_api.Models.DTOs.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest extends UserRequest{
    private String password;
    private String retype_password;
}
