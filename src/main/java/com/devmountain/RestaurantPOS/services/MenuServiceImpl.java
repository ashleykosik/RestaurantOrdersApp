package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.dtos.MenuDto;
import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.entities.Menu;
import com.devmountain.RestaurantPOS.entities.Order;
import com.devmountain.RestaurantPOS.repositories.MenuRepository;
import com.devmountain.RestaurantPOS.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private OrderRepository ordersPlacedRepository;

    // get all
    @Override
    @Transactional
    public List<MenuDto> getAllMenuItems() {
        List<Menu> menuList = menuRepository.findAll();
        List<MenuDto> menuDtoList = menuList.stream().map(menu -> new MenuDto(menu)).collect(Collectors.toList());
        if (menuList.isEmpty()) {
            return Collections.emptyList();
        } else {
            return menuDtoList;
        }
    }

    //get by id
    @Override
    @Transactional
    public Optional<MenuDto> getMenuItemById(Long menuId) {
        Optional<Menu> menuOptional = menuRepository.findById(menuId);
        if (menuOptional.isPresent()) {
            return Optional.of(new MenuDto(menuOptional.get()));
        }
        return Optional.empty();
    }


    //create menu item
    @Override
    @Transactional
    public List<String> createMenuItem(MenuDto menuDto) {
        List<String> response = new ArrayList<>();
        Menu menu = new Menu(menuDto);
        menuRepository.saveAndFlush(menu);
        response.add("http://localhost:8080/");
        return response;
    }

    // post request - add menu item?
//    public void addMenuItem(MenuDto menuDto) {
//        Optional<Order> orderOptional = OrderRepository.findById(orderId);
//        Menu menu = new Menu(menuDto);
//        orderOptional.ifPresent(menu::setNewOrder);
//        menuRepository.saveAndFlush(menu);
//    }

    //backlog - get all menu items on menu page
}
