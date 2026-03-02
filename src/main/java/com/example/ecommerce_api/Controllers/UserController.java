package com.example.ecommerce_api.Controllers;

import com.example.ecommerce_api.Models.DTOs.UserDTO;
import com.example.ecommerce_api.Models.User;
import com.example.ecommerce_api.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @PostMapping("")
    public User createUser(@RequestBody UserDTO user){
        return userService.createUser(user);
    }
}
