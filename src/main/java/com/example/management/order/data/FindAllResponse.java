package com.example.management.order.data;

import lombok.Data;

import java.util.List;

@Data
public class FindAllResponse {
    List<OrderDto> orderDtoList;
}
