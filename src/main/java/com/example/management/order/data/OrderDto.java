package com.example.management.order.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderDto {
    private int id;
    private List<String> productNames;
}
