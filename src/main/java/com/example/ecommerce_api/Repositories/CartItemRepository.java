package com.example.ecommerce_api.Repositories;

import com.example.ecommerce_api.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
