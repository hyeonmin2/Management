package com.example.management.product;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;
}