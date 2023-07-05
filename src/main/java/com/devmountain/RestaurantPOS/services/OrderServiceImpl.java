package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.entities.Menu;
import com.devmountain.RestaurantPOS.entities.Order;
import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.repositories.MenuRepository;
import com.devmountain.RestaurantPOS.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;



    // get all active orders
    @Override
    public List<OrderDto> getAllActiveOrders(boolean complete) {
        Optional<Order> orderOptional = orderRepository.findById();
        if (orderOptional.isComplete()) { // if complete = false in repository
            return Optional.of(new OrderDto(orderOptional.get()));
        }
        return Optional.empty();
    }

    //add
    @Transactional
    public void addOrder(OrderDto orderDto, Long menuId) {
        Order order = new Order(orderDto);
        orderRepository.saveAndFlush(order);
        Optional<Menu> menuOptional = menuRepository.findById(menuId);
        menuOptional.ifPresent(order::setMenu);
        orderRepository.saveAndFlush(order);
    }

    //add menu item & add comment





    // update - mark complete - complete status
    @Override
    @Transactional
    public void updateOrderById(OrderDto orderDto) {
        Optional<Order> orderOptional = orderRepository.findById(orderDto.getId());
        orderOptional.ifPresent( order -> {
            order.setComplete(orderDto.isComplete());
            orderRepository.saveAndFlush(order);
        });
    }


    // delete whole order
    @Transactional
    public void deleteOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        orderOptional.ifPresent(order -> orderRepository.delete(order));
    }

    // delete menu item from ordersPlaced
    @Transactional
    public void deleteOrderPlacedById(Long orderPlacedId) {
        Optional<Order> orderOptional = orderRepository.findById(orderPlacedId); // menuId?
        orderOptional.ifPresent(ordersPlaced -> orderRepository.delete(ordersPlaced));
    }


    // backlog - get orders by date







}
