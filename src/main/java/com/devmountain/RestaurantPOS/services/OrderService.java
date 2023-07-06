package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.dtos.OrderDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface OrderService {
    // get all active orders
    @Transactional
    List<OrderDto> getAllActiveOrders();

    //create order
    @Transactional
    List<String> createOrder(OrderDto orderDto);

    // update - complete status
    @Transactional
    void updateOrderById(OrderDto orderDto);

    // delete whole order
    @Transactional
    void deleteOrderById(Long orderId);
}
