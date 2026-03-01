package com.example.ecommerce_api.Services;

import com.example.ecommerce_api.Models.Cart;
import com.example.ecommerce_api.Models.CartItem;
import com.example.ecommerce_api.Models.Product;
import com.example.ecommerce_api.Repositories.CartItemRepository;
import com.example.ecommerce_api.Repositories.CartRepository;
import com.example.ecommerce_api.Repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    public Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }

    @Transactional
    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }

    @Transactional
    public List<CartItem> getAllCartItems(){
        return cartItemRepository.findAll();
    }

    @Transactional
    public CartItem addItemToCart(Long cart_id, Long product_id){
        Cart cart = cartRepository.findById(cart_id).orElseThrow(
                () -> new RuntimeException("No cart found")
        );

        Product product = productRepository.findById(product_id).orElseThrow(
                () -> new RuntimeException("No item found")
        );

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setCart(cart);

        return cartItemRepository.save(cartItem);
    }
}
