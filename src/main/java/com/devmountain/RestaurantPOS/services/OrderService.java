package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.dtos.OrderDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    int getAllOrders();

    // get all active orders
    @Transactional
    List<OrderDto> getAllActiveOrders();

    //get order by id
    Optional<OrderDto> getOrderById(Long orderId);

    //get all order placed by specific employee
    List<OrderDto> getAllOrdersByEmployee(Long id);

    //create order
    @Transactional
    void createOrder(OrderDto orderDto, Long userId);

    // update - complete status
    @Transactional
    void updateOrderById(OrderDto orderDto);

    @Transactional
    void deleteOrderById(Long orderId);
}
