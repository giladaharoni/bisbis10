package com.att.tdp.bisbis10.enitites;

public class RequestRating {
    public RequestRating(int restaurantId, float rating) {
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    private int restaurantId;
    private float rating;
}
