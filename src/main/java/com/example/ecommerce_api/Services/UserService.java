package com.example.ecommerce_api.Services;

import com.example.ecommerce_api.Models.Cart;
import com.example.ecommerce_api.Models.DTOs.UserDTO.UserRequest;
import com.example.ecommerce_api.Models.DTOs.UserDTO.UserResponse;
import com.example.ecommerce_api.Models.User;
import com.example.ecommerce_api.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CartService cartService;

    public UserService(UserRepository userRepository, CartService cartService) {
        this.userRepository = userRepository;
        this.cartService = cartService;
    }

    @Transactional
    public List<UserResponse> getAllUser(){
        return userRepository.findAll().stream().map(user -> UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build()
        ).toList();
    }

    @Transactional
    public UserResponse getUser(Integer id){
        if (userRepository.findById(id).isEmpty()){
            throw new RuntimeException();
        }

        User user = userRepository.findById(id).get();

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Transactional
    public UserResponse createUser(UserRequest request){
        User user = new User();
        Cart user_cart = new Cart();

        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());

        user_cart.setUser(user);

        cartService.createCart(user_cart);
        user.setCart(user_cart);

        user = userRepository.save(user);
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
