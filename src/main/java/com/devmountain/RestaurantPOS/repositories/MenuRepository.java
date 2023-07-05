package com.devmountain.RestaurantPOS.repositories;

import  com.devmountain.RestaurantPOS.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
