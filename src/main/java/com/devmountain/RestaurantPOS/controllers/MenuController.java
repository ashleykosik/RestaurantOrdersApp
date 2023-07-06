package com.devmountain.RestaurantPOS.controllers;
import java.util.List;
import com.devmountain.RestaurantPOS.dtos.MenuDto;
import com.devmountain.RestaurantPOS.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/order/{orderId}")
    public List<MenuDto> getMenuByOrderId(@PathVariable Long orderId) {
        return MenuService.getMenuByOrderId(orderId);
    }

    @PostMapping("order/{orderId}")
    public void addItem(@RequestBody MenuDto menuDto, @PathVariable Long orderId) {
        menuService.addItem(menuDto, orderId);
    }

    @DeleteMapping("/{menuId}")
    public void deleteItemById(@PathVariable Long menuId) {
        menuService.deleteItemById(menuId);
    }

    @PutMapping
    public void updateItem(@RequestBody MenuDto menuDto) {
        menuService.updateItemById(menuDto);
    }
}
