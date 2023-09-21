package com.example.management.product.repository;

import com.example.management.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryImp {

    Product save(Product newProduct);

    Optional<Product> findById(int id);

    void deleteById(int id);

    List<Product> findAll();

    void deleteAll();
}
