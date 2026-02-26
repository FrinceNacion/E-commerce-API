package com.example.ecommerce_api.Controllers;

import com.example.ecommerce_api.Models.Product;
import com.example.ecommerce_api.Repositories.ProductRepository;
import com.example.ecommerce_api.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Integer product_id){
        return productService.getProductById(product_id);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
