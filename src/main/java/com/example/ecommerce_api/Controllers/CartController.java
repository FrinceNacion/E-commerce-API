package com.example.ecommerce_api.Controllers;

import com.example.ecommerce_api.Models.Cart;
import com.example.ecommerce_api.Models.CartItem;
import com.example.ecommerce_api.Services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("")
    public List<Cart> getAllCartItems(){
        return cartService.getCart();
    }

    @PostMapping("/{cart_id}/item")
    // @RequestBody Long product_id
    public CartItem addToCart(@PathVariable("cart_id") Long cart_id){
        return cartService.addItemToCart(cart_id, 5L);
    }
}
