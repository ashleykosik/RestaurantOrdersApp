package com.devmountain.RestaurantPOS.controllers;

import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/active")
    public List<OrderDto> getAllActiveOrders() {
        return orderService.getAllActiveOrders();
    }

    @GetMapping
    public int getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/createOrder")
    public List<String> createOrder() {
        return orderService.createOrder();
    }

    // change completion status
    @PutMapping
    public void updateOrderById(@RequestBody OrderDto orderDto) {
        orderService.updateOrderById(orderDto);
    }

    @DeleteMapping("/{orderId}")
        public void deleteOrderById(@PathVariable Long orderId) {
            orderService.deleteOrderById(orderId);

    }

}
