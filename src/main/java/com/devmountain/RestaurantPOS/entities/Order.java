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

    @Column(name = "complete", columnDefinition = "boolean default true")
    private boolean complete = false; // default

    //backlog - feedback note
//    @Column(name = "feedback")
//    private String feedback;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "Orders-Placed",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "menuId")
            //String = "comment"
    )
    private Set<Menu> menu = new HashSet<>();

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
