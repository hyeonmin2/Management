package com.example.management.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    public ProductDto saveProduct(String name, int price) {
        return productService.save(name, price);
    }

    public ProductDto findProductById(int id) {
        return productService.findById(id);
    }

    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    public void deleteProductById(int id) {
        productService.deleteById(id);
    }

    public void deleteAll() {
        productService.deleteAll();
    }

    public void updateProductName(int id, String name) {
        productService.updateName(id, name);
    }

    public void updateProductPrice(int id, int price) {
        productService.updatePrice(id, price);
    }
}
