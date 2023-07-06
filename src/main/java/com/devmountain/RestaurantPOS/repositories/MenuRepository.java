package com.devmountain.RestaurantPOS.repositories;


import  com.devmountain.RestaurantPOS.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByIdEquals(Long menuId);
}

