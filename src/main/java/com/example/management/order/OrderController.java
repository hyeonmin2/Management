package com.example.management.order;

import com.example.management.order.data.OrderDto;
import com.example.management.order.data.ProductRequest;
import com.example.management.order.data.FindAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@ResponseBody
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/new")
    public ResponseEntity<OrderDto> newOrder() {
        return ResponseEntity.ok(orderService.saveNew());
    }

    @PutMapping("/order/addProduct")
    public ResponseEntity<OrderDto> addProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(orderService.addProduct(productRequest));
    }

    @PutMapping("/order/removeProduct")
    public ResponseEntity<OrderDto> removeProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(orderService.removeProduct(productRequest));
    }

    @GetMapping("/order/find")
    public ResponseEntity<OrderDto> findOrderById(@RequestParam("orderId") int orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @GetMapping("/order/findAll")
    public ResponseEntity<FindAllResponse> findOrderAll() {
        FindAllResponse findAllResponse = new FindAllResponse();
        findAllResponse.setOrderDtoList(orderService.findAll());
        return ResponseEntity.ok(findAllResponse);
    }

    @DeleteMapping("/order/delete")
    public void deleteOrderById(@RequestParam("orderId") int orderId) {
        orderService.deleteById(orderId);
    }

    @DeleteMapping("/order/deleteAll")
    public void deleteAll() {
        orderService.deleteAll();
    }
}
