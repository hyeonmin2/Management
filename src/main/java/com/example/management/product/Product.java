package com.example.management.product;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Builder
    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}