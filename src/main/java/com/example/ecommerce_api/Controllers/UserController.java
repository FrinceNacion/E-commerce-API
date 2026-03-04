package com.example.ecommerce_api.Controllers;

import com.example.ecommerce_api.Models.DTOs.UserDTO.LoginRequest;
import com.example.ecommerce_api.Models.DTOs.UserDTO.RegisterRequest;
import com.example.ecommerce_api.Models.DTOs.UserDTO.UserRequest;
import com.example.ecommerce_api.Models.DTOs.UserDTO.UserResponse;
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
    public List<UserResponse> getAllUsers(){
        return user_service.getAllUser();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Integer id){
        return user_service.getUser(id);
    }

    @PostMapping("/register")
    public UserResponse createUser(@RequestBody RegisterRequest register_request){
        if (register_request.getPassword().isEmpty()){
            throw new RuntimeException();
        }
        return user_service.createUser(register_request);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest login_request){
        //TODO: implement login with JWT
        return null;
    }
}
