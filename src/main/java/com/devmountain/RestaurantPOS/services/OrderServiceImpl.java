package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.entities.Menu;
import com.devmountain.RestaurantPOS.entities.Order;
import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.repositories.MenuRepository;
import com.devmountain.RestaurantPOS.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;


    // get all active orders
    @Override
    @Transactional
    public List<OrderDto> getAllActiveOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDto> orderDtoList = orderList.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        for (int i = 0; i < orderDtoList.size(); i++) {
            //removed completed orders here
            if (orderDtoList.get(i).isComplete()) {
                orderDtoList.remove(i);
                i--;
            }
        }
        if (orderList.isEmpty()) {
            return Collections.emptyList();
        } else {
            return orderDtoList;
        }
    }

    @Override
    public int getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDto> orderDtoList = orderList.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        return orderDtoList.size();

    }

    //create order
    @Override
    @Transactional
    public List<String> createOrder() {
        List<String> response = new ArrayList<>();
        Order order = new Order();
        orderRepository.saveAndFlush(order);
        response.add("http://localhost:8080/order-form.html");
        return response;
    }


    // update - complete status
    @Override
    @Transactional
    public void updateOrderById(OrderDto orderDto) {
        Optional<Order> orderOptional = orderRepository.findById(orderDto.getOrderId());
        orderOptional.ifPresent(order -> {
            order.setComplete(orderDto.isComplete());
            orderRepository.saveAndFlush(order);
        });
    }


    // delete whole order
    @Override
    @Transactional
    public void deleteOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        orderOptional.ifPresent(order -> orderRepository.delete(order));
    }


    // backlog - get orders by date







}
