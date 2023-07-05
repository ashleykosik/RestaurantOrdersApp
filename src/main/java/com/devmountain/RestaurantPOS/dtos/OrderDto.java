package com.devmountain.RestaurantPOS.dtos;

import com.devmountain.RestaurantPOS.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {

    private Long orderId;
    private Date date = new Date();
    private boolean complete;

    public OrderDto (Order order) {
        if (order.getOrderId() != null) {
            this.orderId = order.getOrderId();
        }
        if (order.getDate() != null) {
            this.date = order.getDate();
        }
        if (order.isComplete()) {
            this.complete = order.isComplete();
        }
    }


}
