package com.devmountain.RestaurantPOS.entities;


import com.devmountain.RestaurantPOS.dtos.OrderDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "date")
    private Date date = new Date();

    @Column(name = "complete", columnDefinition = "boolean default false")
    private boolean complete = false; // default

    @OneToMany(mappedBy ="order", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Menu> menuSet = new HashSet<>();


    public Order (OrderDto orderDto) {
        if (orderDto.getOrderId() != null) {
            this.orderId = orderDto.getOrderId();
        }
        if (orderDto.getDate() != null) {
            this.date = orderDto.getDate();
        }
        if (orderDto.isComplete()) {
            this.complete = orderDto.isComplete();
        }
    }
}
