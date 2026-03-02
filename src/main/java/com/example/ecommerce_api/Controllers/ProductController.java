package com.example.ecommerce_api.Controllers;

import com.example.ecommerce_api.Models.Product;
import com.example.ecommerce_api.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService product_service;

    public ProductController(ProductService product_service) {
        this.product_service = product_service;
    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        return product_service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long product_id){
        return product_service.getProductById(product_id);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product){
        return product_service.createProduct(product);
    }
}
