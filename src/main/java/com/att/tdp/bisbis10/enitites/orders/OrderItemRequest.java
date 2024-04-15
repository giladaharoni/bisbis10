package com.att.tdp.bisbis10.enitites.orders;

public class OrderItemRequest {
    public OrderItemRequest(int dishId, int amount) {
        this.dishId = dishId;
        this.amount = amount;
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

    private int dishId;
    private int amount;
}
