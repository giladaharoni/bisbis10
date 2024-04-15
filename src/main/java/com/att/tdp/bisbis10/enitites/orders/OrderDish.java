package com.att.tdp.bisbis10.enitites.orders;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class OrderDish {
    @EmbeddedId
    private OrderDishPK id;

    public OrderDish(){
        super();
    }

    public OrderDish(OrderDishPK id) {
        this.id = id;
    }

    public OrderDishPK getId() {
        return id;
    }

    public void setId(OrderDishPK id) {
        this.id = id;
    }
}
