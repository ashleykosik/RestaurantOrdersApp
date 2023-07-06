package com.devmountain.RestaurantPOS.dtos;

import com.devmountain.RestaurantPOS.entities.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto implements Serializable {

    private Long id;
    private String item;

    public MenuDto (Menu menu) {
        if (menu.getId() != null) {
            this.id = menu.getId();
        }
        if (menu.getItem() != null) {
            this.item = menu.getItem();
        }
    }
}
