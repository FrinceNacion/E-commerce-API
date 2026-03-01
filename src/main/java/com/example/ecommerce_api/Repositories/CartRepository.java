package com.example.ecommerce_api.Repositories;

import com.example.ecommerce_api.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
