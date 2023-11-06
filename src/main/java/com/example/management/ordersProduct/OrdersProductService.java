package com.example.management.ordersProduct;

import com.example.management.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrdersProductService {
    private final OrdersProductRepository ordersProductRepository;
    private final ProductRepository productRepository;

    public List<String> top() {
        List<Integer> topId = ordersProductRepository.top();
        List<String> topName = new ArrayList<>();

        for(int productId : topId) {
            String productName = productRepository.findById(productId).orElseThrow().getName();
            topName.add(productName);
        }

        return topName;
    }
}
