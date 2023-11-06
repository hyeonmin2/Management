package com.example.management.ordersProduct;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrdersProductController {
    private final OrdersProductService ordersProductService;

    @GetMapping("/product/top")
    public ResponseEntity<List<String>> top() {
        return ResponseEntity.ok(ordersProductService.top());
    }
}
