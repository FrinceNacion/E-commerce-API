package com.example.ecommerce_api.Controllers;

import com.example.ecommerce_api.Models.Cart;
import com.example.ecommerce_api.Models.CartItem;
import com.example.ecommerce_api.Services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cart_service;

    public CartController(CartService cart_service) {
        this.cart_service = cart_service;
    }

    @GetMapping("")
    public List<Cart> getAllCartItems(){
        return cart_service.getCart();
    }

    @PostMapping("/{cart_id}/item")
    // @RequestBody Long product_id
    public CartItem addToCart(@PathVariable("cart_id") Long cart_id, @RequestBody Long product_id){
        return cart_service.addItemToCart(cart_id, product_id);
    }
}
