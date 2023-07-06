package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.dtos.MenuDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    // get all
    @Transactional
    List<MenuDto> getAllMenuItems();

    //get by id
    @Transactional
    Optional<MenuDto> getMenuItemById(Long menuId);

    //create menu item
    @Transactional
    List<String> createMenuItem(MenuDto menuDto);
}
