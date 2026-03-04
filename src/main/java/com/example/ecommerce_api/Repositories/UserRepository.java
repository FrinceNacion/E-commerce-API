package com.example.ecommerce_api.Repositories;

import com.example.ecommerce_api.Models.DTOs.UserDTO.UserResponse;
import com.example.ecommerce_api.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
