package com.example.ecommerce_api.Models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Column(name = "is_deleted")
    private boolean is_deleted;
}
