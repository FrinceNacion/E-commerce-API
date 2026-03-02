package com.example.ecommerce_api.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 100)
    private String product_name;

    @Column(name = "product_price")
    private float product_price;

    @Column(name = "product_stock")
    private Integer product_stock;

    @Column(name = "product_category")
    private String product_category;

    @Column(name = "product_description")
    private String product_description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cart_item;
}
