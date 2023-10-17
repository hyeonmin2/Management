package com.example.management.product;

import com.example.management.product.Data.ProductDto;
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

    public Product convertToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .price(productDto.getPrice())
                .name(productDto.getName())
                .build();
    }

    public ProductDto save(ProductDto productDto) {
        Product newProduct = convertToProduct(productDto);
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

    public ProductDto updateProduct(ProductDto productDto) {
        Product newProduct = convertToProduct(productDto);
        Product savedProduct = productRepository.save(newProduct);
        return convertToDto(savedProduct);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
