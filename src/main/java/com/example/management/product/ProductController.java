package com.example.management.product;

import com.example.management.product.Data.FindAllResponse;
import com.example.management.product.Data.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.save(productDto));
    }

    @GetMapping("/find")
    public ResponseEntity<ProductDto> findProductById(@RequestParam("productId") int productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping("/find-all")
    public ResponseEntity<FindAllResponse> findAll() {
        FindAllResponse findAllResponse = new FindAllResponse();
        findAllResponse.setProductDtoList(productService.findAll());
        return ResponseEntity.ok(findAllResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @DeleteMapping("/delete")
    public void deleteProductById(@RequestParam("productId") int productId) {
        productService.deleteById(productId);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll() {
        productService.deleteAll();
    }
}
