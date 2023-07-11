package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.entities.Order;
import com.devmountain.RestaurantPOS.entities.Menu;
import com.devmountain.RestaurantPOS.dtos.MenuDto;
import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.devmountain.RestaurantPOS.repositories.MenuRepository;
import com.devmountain.RestaurantPOS.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private OrderRepository orderRepository;

    //get menu items by order id
    @Override
    @Transactional
    public List<MenuDto> getMenuByOrderId(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            List<Menu> menuList = menuRepository.findAllByOrderEquals(orderOptional.get());
            return menuList.stream().map(item -> new MenuDto(item)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    //add menu item
    @Override
    @Transactional
    public void addItem(MenuDto menuDto, Long orderId) {
        //finds order by id
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        // creates menu item
        Menu menu = new Menu(menuDto);
        // sets relationship between menu item and order
        orderOptional.ifPresent(menu::setOrder);
        menuRepository.saveAndFlush(menu);
    }

    //delete menu item
    @Override
    @Transactional
    public void deleteItemById(Long menuId) {
        Optional<Menu> menuOptional = menuRepository.findById(menuId);
        menuOptional.ifPresent(menu -> menuRepository.delete(menu));
    }
    //update menu item
    @Override
    @Transactional
    public void updateItemById(MenuDto menuDto) {
        Optional<Menu> menuOptional = menuRepository.findById(menuDto.getId());
        menuOptional.ifPresent(menu -> {
            menu.setItem(menuDto.getItem());
            menuRepository.saveAndFlush(menu);
        });
    }
}
