package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.entities.Menu;
import com.devmountain.RestaurantPOS.entities.Order;
import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.dtos.MenuDto;
import com.devmountain.RestaurantPOS.repositories.MenuRepository;
import com.devmountain.RestaurantPOS.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;



    // backlog - get orders by date
//    @Override
//    @Transactional
//    public List<OrderDto> getOrderByDate(Date date) {
//        Optional<Order> orderOptional = orderRepository.findByDate(date);
//        //if complete = false
//        if (orderOptional.isPresent()) {
//            List<Order> orderList = orderRepository.findAllByDateEquals(orderOptional.get());
//            return orderList.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
//        }
//        return Collections.emptyList();
//    }

    // get order by id
//    @Override
//    @Transactional
//    public Optional<OrderDto> getOrderById(Long orderId) {
//        Optional<Order> orderOptional = orderRepository.findById(orderId);
//        if (!orderOptional.isComplete()) {
//            return Optional.of(new OrderDto(orderOptional.get()));
//        }
//        return Optional.empty();
//    }

    //get all
    @Override
    @Transactional
    public List<OrderDto> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDto> orderDtoList = orderList.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        if (orderList.isEmpty()) {
            return Collections.emptyList();
        } else {
            return orderDtoList;
        }
    }

    //get all active orders
    @Override
    @Transactional
    public List<OrderDto> getAllActiveOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDto> orderDtoList = orderList.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        for (int i = 0; i < orderDtoList.size(); i++) {
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

    //create an order

    @Transactional
    public List<String> createOrder(OrderDto orderDto) {
        List<String> response = new ArrayList<>();
        Order order = new Order(orderDto);
        orderRepository.saveAndFlush(order);
        response.add("http://localhost:8080/");
        return response;
    }

    //add menu item
    //put request - update menuId
    @Override
    @Transactional
    public void updateMenuById(MenuDto menuDto) {
        Optional<Menu> menuOptional = menuRepository.findById(menuDto.getId());
        menuOptional.ifPresent(menu -> {
            menu.setMenuId(menuDto.getId());
            menuRepository.saveAndFlush(menu);
        });
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

    // delete menu item from ordersPlaced
    @Override
    @Transactional
    public void deleteOrderPlacedById(Long menuId) {
        Optional<Order> orderOptional = orderRepository.findById(menuId); // menuId?
        orderOptional.ifPresent(order -> orderRepository.delete(order));
    }










}
