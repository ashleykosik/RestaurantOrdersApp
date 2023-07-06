package com.devmountain.RestaurantPOS.controllers;

import com.devmountain.RestaurantPOS.dtos.MenuDto;
import com.devmountain.RestaurantPOS.entities.Order;
import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.services.MenuService;
import com.devmountain.RestaurantPOS.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> getAllActiveOrders() {
        return OrderService.getAllActiveOrders();
    }

    @PostMapping("/createOrder")
    public List<String> createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
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
