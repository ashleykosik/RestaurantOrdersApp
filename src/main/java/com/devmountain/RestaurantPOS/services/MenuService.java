package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.dtos.MenuDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MenuService {
    //get menu items by order id
    @Transactional
    List<MenuDto> getMenuByOrderId(Long orderId);

    //add menu item
    @Transactional
    void addItem(MenuDto menuDto, Long orderId);

    //delete menu item
    @Transactional
    void deleteItemById(Long menuId);

    //update menu item
    @Transactional
    void updateItemById(MenuDto menuDto);
}
