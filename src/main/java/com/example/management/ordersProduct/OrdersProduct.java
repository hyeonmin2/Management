package com.example.management.ordersProduct;

import com.example.management.order.Order;
import com.example.management.product.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class OrdersProduct {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public OrdersProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
