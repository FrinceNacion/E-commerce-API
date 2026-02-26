package com.example.ecommerce_api.Services;

import com.example.ecommerce_api.Models.Product;
import com.example.ecommerce_api.Repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public Optional<Product> getProductById(Integer id){
        return productRepository.findById(id);
    }
}
