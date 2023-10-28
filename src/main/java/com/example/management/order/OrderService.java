package com.example.management.order;

import com.example.management.order.data.OrderDto;
import com.example.management.order.data.ProductRequest;
import com.example.management.orderProduct.OrdersProduct;
import com.example.management.product.Product;
import com.example.management.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderDto saveNew() {
        Order order = orderRepository.save(new Order());
        return convertToDto(order);
    }

    public OrderDto addProduct(ProductRequest productRequest) {
        int orderId = productRequest.getOrderId();
        int productId = productRequest.getProductId();

        Order order = orderRepository.findById(orderId).orElseThrow(()
                -> new NoSuchElementException("No value present for orderId: " + orderId));
        order.addProduct(productRepository.findById(productId).orElseThrow());

        return convertToDto(orderRepository.save(order));
    }

    public OrderDto removeProduct(ProductRequest productRequest) {
        int orderId = productRequest.getOrderId();
        int productId = productRequest.getProductId();
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.deleteProduct(productRepository.findById(productId).orElseThrow());
        return convertToDto(orderRepository.save(order));
    }

    public OrderDto findById(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return convertToDto(order);
    }

    public List<OrderDto> findAll() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            orderDtoList.add(convertToDto(order));
        }
        return orderDtoList;
    }

    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }

    public OrderDto convertToDto(Order order) {
        ArrayList<String> productNames = new ArrayList<>();

        for (OrdersProduct ordersProduct : order.getOrdersProducts()) {
            Product product = ordersProduct.getProduct();
            productNames.add(product.getName());
        }

        return OrderDto.builder()
                .id(order.getId())
                .productNames(productNames)
                .build();
    }

}
