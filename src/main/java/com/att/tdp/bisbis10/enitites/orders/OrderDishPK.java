package com.att.tdp.bisbis10.enitites.orders;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDishPK implements Serializable {
    public OrderDishPK(String orderId, int dishId, int amount) {
        this.orderId = orderId;
        this.dishId = dishId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderDishPK() {
        super();
    }

    private String orderId;
    private int dishId;
    private int amount;
}
