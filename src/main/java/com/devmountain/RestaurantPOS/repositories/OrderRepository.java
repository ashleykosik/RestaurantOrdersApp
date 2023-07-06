package com.devmountain.RestaurantPOS.repositories;

import com.devmountain.RestaurantPOS.entities.Menu;
import com.devmountain.RestaurantPOS.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(Long orderId);

    //find by date
}
