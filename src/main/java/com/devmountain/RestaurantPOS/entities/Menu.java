package com.devmountain.RestaurantPOS.entities;
import com.devmountain.RestaurantPOS.dtos.MenuDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuId")
    private Long menuId;

    @Column(name = "item")
    private String item;

    @ManyToOne
    @JsonBackReference
    private Order order;



    public Long getId() {
        return menuId;
    }

    public void setId(Long menuId) {
        this.menuId = menuId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


    public Menu (MenuDto menuDto) {
        if (menuDto.getId() != null) {
            this.menuId = menuDto.getId();
        }
        if (menuDto.getItem() != null) {
            this.item = menuDto.getItem();
        }
    }
}
