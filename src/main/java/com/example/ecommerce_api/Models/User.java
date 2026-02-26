package com.example.ecommerce_api.Models;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "Users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "email", length = 100)
    private String email;

}
