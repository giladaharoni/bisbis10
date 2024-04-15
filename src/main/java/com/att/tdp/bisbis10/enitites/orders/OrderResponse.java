package com.att.tdp.bisbis10.enitites.orders;

public class OrderResponse {
    public OrderResponse(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private String orderId;
}
