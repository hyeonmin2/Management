package com.example.management.ordersProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersProductRepository extends JpaRepository<OrdersProduct, Integer> {

    @Query("SELECT o.product.id FROM OrdersProduct o GROUP BY o.product.id ORDER BY COUNT(o.product.id) DESC LIMIT 3")
    List<Integer> top();
}
