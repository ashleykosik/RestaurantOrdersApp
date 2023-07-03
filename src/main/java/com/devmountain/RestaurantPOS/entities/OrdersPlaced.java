package com.devmountain.RestaurantPOS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.Set;
@Entity
public class OrdersPlaced {
        @Id
        Long id;

        @ManyToOne
        @JoinColumn(name = "order_id")
        Order order;

        @ManyToOne
        @JoinColumn(name = "menu_id")
        Menu menu;

        String note;

        // standard constructors, getters, and setters
    }
//
//    class Menu {
//
//        // ...
//
//        @OneToMany(mappedBy = "menu")
//        Set<OrdersPlaced> placedOrder;
//
//        // ...
//    }




