package com.example.ecommerce_api.Services;

import com.example.ecommerce_api.Models.Cart;
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
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(User user){
        Cart user_cart = new Cart();
        user_cart.setUser(user);
        cartService.createCart(user_cart);
        user.setCart(user_cart);

        return userRepository.save(user);
    }
}
