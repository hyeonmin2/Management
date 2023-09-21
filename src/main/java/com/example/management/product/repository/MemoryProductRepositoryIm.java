package com.example.management.product.repository;

import com.example.management.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryProductRepositoryIm implements ProductRepositoryImp {
    List<Product> productList = new ArrayList<>();

    @Override
    public Product save(Product newProduct) {
        Optional<Product> hasProduct = productList.stream()
                .filter(product -> product.getId() == newProduct.getId())
                .findAny();
        if(hasProduct.isPresent()) {
            hasProduct.get().setName(newProduct.getName());
            hasProduct.get().setPrice(newProduct.getPrice());
            return hasProduct.get();
        }
        else {
            productList.add(newProduct);
            return newProduct;
        }
    }

    @Override
    public Optional<Product> findById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findAny();
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void deleteById(int id) {
        Optional<Product> hasProduct = productList.stream()
                .filter(product -> product.getId() == id)
                .findAny();
        hasProduct.ifPresent(product -> productList.remove(product));
    }

    @Override
    public void deleteAll() {
        productList.clear();
    }
}
