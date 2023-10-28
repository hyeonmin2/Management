package com.example.management.order;

import com.example.management.order.data.OrderDto;
import com.example.management.order.data.ProductRequest;
import com.example.management.order.data.FindAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/new")
    public ResponseEntity<OrderDto> newOrder() {
        return ResponseEntity.ok(orderService.saveNew());
    }

    @PutMapping("/add-product")
    public ResponseEntity<OrderDto> addProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(orderService.addProduct(productRequest));
    }

    @PutMapping("/remove-product")
    public ResponseEntity<OrderDto> removeProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(orderService.removeProduct(productRequest));
    }

    @GetMapping("/find")
    public ResponseEntity<OrderDto> findOrderById(@RequestParam("orderId") int orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @GetMapping("/find-all")
    public ResponseEntity<FindAllResponse> findOrderAll() {
        FindAllResponse findAllResponse = new FindAllResponse();
        findAllResponse.setOrderDtoList(orderService.findAll());
        return ResponseEntity.ok(findAllResponse);
    }

    @DeleteMapping("/delete")
    public void deleteOrderById(@RequestParam("orderId") int orderId) {
        orderService.deleteById(orderId);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll() {
        orderService.deleteAll();
    }
}
