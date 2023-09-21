package com.example.management.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void testSave() {
        // Given
        Product newProduct = new Product();
        newProduct.setName("Test Product");
        newProduct.setPrice(10);


        // When
        ProductDto savedProductDto = productService.save("Test Product", 10);

        // Then
        assertNotNull(savedProductDto);
        assertEquals("Test Product", savedProductDto.getName());
        assertEquals(10, savedProductDto.getPrice());
    }

    @Test
    void testFindById() {
        // Given
        int productId = 1;
        Product newProduct = new Product();
        newProduct.setId(productId);
        newProduct.setName("Test Product");
        newProduct.setPrice(10);

        // When
        productService.save(newProduct);
        ProductDto foundProductDto = productService.findById(productId);

        // Then
        assertNotNull(foundProductDto);
        assertEquals("Test Product", foundProductDto.getName());
        assertEquals(10, foundProductDto.getPrice());
    }

    @Test
    void testDeleteById() {
        // Given
        int productId = 1;

        // When
        productService.deleteById(productId);

        // Then
    }

    @Test
    void testFindAll() {
        // Given
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Product 1");
        product1.setPrice(10);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Product 2");
        product2.setPrice(20);

        // When
        productService.save(product1);
        productService.save(product2);
        List<ProductDto> productDtoList = productService.findAll();

        // Then
        assertNotNull(productDtoList);
        assertEquals(2, productDtoList.size());
        assertEquals("Product 1", productDtoList.get(0).getName());
        assertEquals("Product 2", productDtoList.get(1).getName());
    }
}
