package com.example.ecommerce_api.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "email", length = 100)
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

}
