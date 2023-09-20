package com.example.management.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDto convertToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .build();
    }

    public ProductDto save(String name, int price) {
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        Product savedProduct = productRepository.save(newProduct);
        return convertToDto(savedProduct);
    }

    public ProductDto findById(int id) {
        Product findProduct = productRepository.findById(id).orElseThrow();
        return convertToDto(findProduct);
    }

    public List<ProductDto> findAll() {
        List<Product> productList =  productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product : productList) {
            ProductDto productDto = convertToDto(product);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public void updateName(int id, String name) {
        Product findProduct = productRepository.findById(id).orElseThrow();
        findProduct.setName(name);
        productRepository.save(findProduct);
    }

    public void updatePrice(int id, int price) {
        Product findProduct = productRepository.findById(id).orElseThrow();
        findProduct.setPrice(price);
        productRepository.save(findProduct);
    }
}
