package com.example.management.product.Data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private int id;
    private String name;
    private int price;
}
