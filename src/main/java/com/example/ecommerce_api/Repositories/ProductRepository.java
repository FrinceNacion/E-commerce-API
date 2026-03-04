package com.example.ecommerce_api.Repositories;

import com.example.ecommerce_api.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
