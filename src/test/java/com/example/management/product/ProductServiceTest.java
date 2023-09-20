package com.example.management.product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
        productService = new ProductService(productRepository);
    }

    @Test
    void testSave() {
        // Given
        Product newProduct = new Product();
        newProduct.setName("Test Product");
        newProduct.setPrice(10);

        when(productRepository.save(any())).thenReturn(newProduct);

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
        Product findProduct = new Product();
        findProduct.setId(productId);
        findProduct.setName("Test Product");
        findProduct.setPrice(10);

        when(productRepository.findById(productId)).thenReturn(Optional.of(findProduct));

        // When
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
        verify(productRepository).deleteById(productId);
    }

    @Test
    void testUpdateName() {
        // Given
        int productId = 1;
        String newName = "Updated Product Name";
        Product findProduct = new Product();
        findProduct.setId(productId);
        findProduct.setName("Test Product");
        findProduct.setPrice(10);

        when(productRepository.findById(productId)).thenReturn(Optional.of(findProduct));
        when(productRepository.save(any())).thenReturn(findProduct);

        // When
        productService.updateName(productId, newName);

        // Then
        assertEquals(newName, findProduct.getName());
    }

    @Test
    void testUpdatePrice() {
        // Given
        int productId = 1;
        int newPrice = 20;
        Product findProduct = new Product();
        findProduct.setId(productId);
        findProduct.setName("Test Product");
        findProduct.setPrice(10);

        when(productRepository.findById(productId)).thenReturn(Optional.of(findProduct));
        when(productRepository.save(any())).thenReturn(findProduct);

        // When
        productService.updatePrice(productId, newPrice);

        // Then
        assertEquals(newPrice, findProduct.getPrice());
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

        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        // When
        List<ProductDto> productDtoList = productService.findAll();

        // Then
        assertNotNull(productDtoList);
        assertEquals(2, productDtoList.size());
        assertEquals("Product 1", productDtoList.get(0).getName());
        assertEquals("Product 2", productDtoList.get(1).getName());
    }
}
