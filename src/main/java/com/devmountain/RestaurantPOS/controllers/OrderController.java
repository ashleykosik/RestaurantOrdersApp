package com.devmountain.RestaurantPOS.controllers;

import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.services.MenuService;
import com.devmountain.RestaurantPOS.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MenuService menuService;


    //create order / add order
    @PostMapping
    public List<String> createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }
}


