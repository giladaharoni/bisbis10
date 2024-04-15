package com.att.tdp.bisbis10.enitites.orders;

import java.util.Set;

public class OrderRequest {
    public OrderRequest(int restaurantId, Set<OrderItemRequest> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Set<OrderItemRequest> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemRequest> orderItems) {
        this.orderItems = orderItems;
    }

    private int restaurantId;
    private Set<OrderItemRequest> orderItems;
}
