package com.example.ecommerce_api.Services;

import com.example.ecommerce_api.Models.Cart;
import com.example.ecommerce_api.Models.DTOs.CartDTO;
import com.example.ecommerce_api.Models.DTOs.CartItemDTO;
import com.example.ecommerce_api.Models.DTOs.ProductDTO;
import com.example.ecommerce_api.Models.DTOs.UserDTO;
import com.example.ecommerce_api.Models.User;
import com.example.ecommerce_api.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CartService cartService;

    public UserService(UserRepository userRepository, CartService cartService) {
        this.userRepository = userRepository;
        this.cartService = cartService;
    }

    @Transactional
    public List<UserDTO> getAllUser(){
        return userRepository.findAll().stream().map(user -> new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                new CartDTO(
                        user.getCart().getId(),
                        user.getCart().getCart_item().stream().map(
                                cartItem -> new CartItemDTO(cartItem.getId(),
                                        new ProductDTO(cartItem.getProduct().getId(), cartItem.getProduct().getProduct_name(), cartItem.getProduct().getProduct_price()))
                        ).toList()
                )
        )).toList();
    }

    @Transactional
    public UserDTO getUser(Long id){
        User user = userRepository.findById(id).get();
        Cart cart = user.getCart();
        List<CartItemDTO> cartItems = cart.getCart_item().stream().map(
                cartItem -> new CartItemDTO(cartItem.getId(),
                        new ProductDTO(cartItem.getProduct().getId(), cartItem.getProduct().getProduct_name(), cartItem.getProduct().getProduct_price()))
        ).toList();

        CartDTO cartResponse = new CartDTO(cart.getId(), cartItems);

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                cartResponse);
    }

    @Transactional
    public User createUser(UserDTO request){
        User user = new User();
        Cart user_cart = new Cart();

        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());

        user_cart.setUser(user);

        cartService.createCart(user_cart);
        user.setCart(user_cart);

        return userRepository.save(user);
    }
}
