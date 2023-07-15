package com.devmountain.RestaurantPOS.repositories;

import com.devmountain.RestaurantPOS.entities.Employee;
import com.devmountain.RestaurantPOS.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByEmployeeEquals(Employee employee);
}
