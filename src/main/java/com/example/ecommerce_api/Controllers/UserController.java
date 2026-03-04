package com.example.ecommerce_api.Controllers;

import com.example.ecommerce_api.Models.DTOs.UserDTO;
import com.example.ecommerce_api.Models.User;
import com.example.ecommerce_api.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService user_service;

    public UserController(UserService user_service) {
        this.user_service = user_service;
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers(){
        return user_service.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Integer id){
        return user_service.getUser(id);
    }

    @PostMapping("")
    public User createUser(@RequestBody UserDTO user){
        return user_service.createUser(user);
    }
}
