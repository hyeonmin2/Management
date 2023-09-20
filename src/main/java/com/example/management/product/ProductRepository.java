package com.example.management.product;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product newProduct);

    Optional<Product> findById(int id);

    void deleteById(int id);

    List<Product> findAll();

    void deleteAll();
}
