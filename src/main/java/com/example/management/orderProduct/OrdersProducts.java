//package com.example.management.orderProduct;
//
//import com.example.management.order.Order;
//import com.example.management.product.Product;
//import jakarta.persistence.*;
//
//@Entity
//public class OrdersProducts {
//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    @OneToOne
//    @JoinColumn(name = "orders_id")
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "products_id")
//    private Product product;
//}
