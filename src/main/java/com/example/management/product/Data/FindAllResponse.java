package com.example.management.product.Data;

import lombok.Data;

import java.util.List;

@Data
public class FindAllResponse {
    List<ProductDto> productDtoList;
}
