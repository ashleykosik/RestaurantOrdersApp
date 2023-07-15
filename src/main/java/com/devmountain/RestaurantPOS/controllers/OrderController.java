package com.devmountain.RestaurantPOS.controllers;

import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/employee/{id}")
    public List<OrderDto> getOrdersByEmployee(@PathVariable Long id) {
        return orderService.getAllOrdersByEmployee(id);
    }

    @GetMapping("/{orderId}")
    public Optional<OrderDto> getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping("createOrder/{userId}")
    public void createOrder(@RequestBody OrderDto orderDto, @PathVariable Long userId) {
        System.out.println(orderDto);
        System.out.println(userId);
        orderService.createOrder(orderDto, userId);
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
