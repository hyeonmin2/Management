package com.example.management.order;

import com.example.management.orderProduct.OrdersProduct;
import com.example.management.product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Entity(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrdersProduct> ordersProducts = new ArrayList<>();

    public void addProduct(Product product) {
        OrdersProduct newOrdersProduct = OrdersProduct.builder()
                .product(product)
                .order(this)
                .build();
        ordersProducts.add(newOrdersProduct);
    }

    public void deleteProduct(Product product) {
        boolean deleted = false;
        for (OrdersProduct ordersProduct : ordersProducts) {
            if(ordersProduct.getProduct().equals(product)) {
                ordersProducts.remove(ordersProduct);
                deleted = true;
                break;
            }
        }
        if(!deleted)
            throw new NoSuchElementException();
    }
}
