package com.example.ecommerce_api.Models.DTOs.UserDTO;

import com.example.ecommerce_api.Models.User;

public class UserMapper {

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
}
