package com.example.ecommerce_api.Controllers;

import com.example.ecommerce_api.Models.User;
import com.example.ecommerce_api.Repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
