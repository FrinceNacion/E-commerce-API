package com.example.ecommerce_api.Models.DTOs.UserDTO;

import com.example.ecommerce_api.Models.RoleEnum;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private String username;
    private String email;
    private RoleEnum role;
}
