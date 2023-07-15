package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.entities.Employee;
import com.devmountain.RestaurantPOS.entities.Order;
import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.repositories.EmployeeRepository;
import com.devmountain.RestaurantPOS.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private EmployeeRepository employeeRepository;


    @Override
    public int getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDto> orderDtoList = orderList.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        return orderDtoList.size();
    }

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

    //get order by id - needed for edits to work
    @Override
    public Optional<OrderDto> getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isPresent()) {
            return Optional.of(new OrderDto(orderOptional.get()));
        }
        return Optional.empty();
    }

    //get all order placed by specific employee
    @Override
    public List<OrderDto> getAllOrdersByEmployee(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()) {
            List<Order> orderList = orderRepository.findAllByEmployeeEquals(employeeOptional.get());
            return orderList.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    //create order
    @Override
    @Transactional
    public void createOrder(OrderDto orderDto, Long userId) {
        System.out.println(orderDto);
        Optional<Employee> employeeOptional = employeeRepository.findById(userId);
        Order order = new Order(orderDto);
        System.out.println(order);
        employeeOptional.ifPresent(order::setEmployee);
        orderRepository.saveAndFlush(order);
    }


    // update order note
    @Override
    @Transactional
    public void updateOrderById(OrderDto orderDto) {
        Optional<Order> orderOptional = orderRepository.findById(orderDto.getOrderId());
        orderOptional.ifPresent(order -> {
            order.setItem(orderDto.getItem());
            orderRepository.saveAndFlush(order);
        });
    }

    // update status to complete

    // delete whole order
    @Override
    @Transactional
    public void deleteOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        orderOptional.ifPresent(order -> orderRepository.delete(order));
    }


    // backlog - get orders by date







}
