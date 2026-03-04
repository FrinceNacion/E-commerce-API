package com.example.ecommerce_api.Services;

import com.example.ecommerce_api.Models.Product;
import com.example.ecommerce_api.Repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository product_repository;

    public ProductService(ProductRepository product_repository){
        this.product_repository = product_repository;
    }

    @Transactional
    public Product createProduct(Product product){
        return product_repository.save(product);
    }

    @Transactional
    public List<Product> getAllProducts(){
        return product_repository.findAll();
    }

    @Transactional
    public Optional<Product> getProductById(Integer id){
        return product_repository.findById(id);
    }
}
