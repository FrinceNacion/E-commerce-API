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
    private final CartRepository cart_repository;
    private final ProductRepository product_repository;
    private final CartItemRepository cart_item_repository;

    public CartService(CartRepository cart_repository, ProductRepository product_repository, CartItemRepository cart_item_repository) {
        this.cart_repository = cart_repository;
        this.product_repository = product_repository;
        this.cart_item_repository = cart_item_repository;
    }

    @Transactional
    public Cart createCart(Cart cart){
        return cart_repository.save(cart);
    }

    @Transactional
    public List<Cart> getCart(){
        return cart_repository.findAll();
    }

    @Transactional
    public List<CartItem> getAllCartItems(){
        return cart_item_repository.findAll();
    }

    @Transactional
    public CartItem addItemToCart(Long cart_id, Long product_id){
        Cart cart = cart_repository.findById(cart_id).orElseThrow(
                () -> new RuntimeException("No cart found")
        );

        Product product = product_repository.findById(product_id).orElseThrow(
                () -> new RuntimeException("No item found")
        );

        CartItem cart_item = new CartItem();
        cart_item.setProduct(product);
        cart_item.setCart(cart);

        return cart_item_repository.save(cart_item);
    }

}
