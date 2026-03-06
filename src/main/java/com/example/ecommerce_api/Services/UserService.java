package com.example.ecommerce_api.Services;

import com.example.ecommerce_api.Models.Cart;
import com.example.ecommerce_api.Models.DTOs.UserDTO.*;
import com.example.ecommerce_api.Models.User;
import com.example.ecommerce_api.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository user_repository;
    private final CartService cart_service;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository user_repository, CartService cart_service, PasswordEncoder passwordEncoder) {
        this.user_repository = user_repository;
        this.cart_service = cart_service;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public List<UserResponse> getAllUser(){
        return user_repository.findAll().stream().map(UserMapper::toUserResponse).toList();
    }

    @Transactional
    public UserResponse getUser(Integer id){
        if (user_repository.findById(id).isEmpty()){
            throw new RuntimeException();
        }

        User user = user_repository.findById(id).get();

        return UserMapper.toUserResponse(user);
    }

    @Transactional
    public UserResponse getUserByEmail(String email){
        if (user_repository.getByEmail(email).isEmpty()){
            throw new RuntimeException();
        }
        User user =  user_repository.getByEmail(email).get();
        return UserMapper.toUserResponse(user);
    }

    @Transactional
    public ResponseEntity<?> createUser(RegisterRequest request){
        User user = new User();
        Cart user_cart = new Cart();

        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user_cart.setUser(user);

        cart_service.createCart(user_cart);
        user.setCart(user_cart);

        user_repository.save(user);
        return ResponseEntity.ok("User registered");
    }

    @Transactional
    public String login(LoginRequest request){
        if (!user_repository.existsByEmail(request.getEmail()) || !user_repository.existsByUsername(request.getUsername())){
            throw new RuntimeException();
        }
        UserResponse user = getUserByEmail(request.getEmail());
        //if (request.getPassword().equals())
        //TODO: update mock login
        return "";
    }
}
