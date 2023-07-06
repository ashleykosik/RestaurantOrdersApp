package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.dtos.MenuDto;
import com.devmountain.RestaurantPOS.dtos.OrderDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface OrderService {
    //get all
    @Transactional
    List<OrderDto> getAllOrders();

    //get all active orders
    @Transactional
    List<OrderDto> getAllActiveOrders();

    //create an order
    @Transactional
    List<String> createOrder(OrderDto orderDto);

    //add menu item
    //put request - update menuId
    @Transactional
    void updateMenuById(MenuDto menuDto);

    // update - complete status
    @Transactional
    void updateOrderById(OrderDto orderDto);

    // delete whole order
    @Transactional
    void deleteOrderById(Long orderId);

    // delete menu item from ordersPlaced
    @Transactional
    void deleteOrderPlacedById(Long menuId);
}
