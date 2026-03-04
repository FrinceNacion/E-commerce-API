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
    private Integer id;

    @Column(name = "name", length = 100)
    private String product_name;

    @Column(name = "price")
    private float product_price;

    @Column(name = "stock")
    private Integer product_stock;

    @Column(name = "category")
    private String product_category;

    @Column(name = "description")
    private String product_description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cart_item;
}
