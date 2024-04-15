package com.att.tdp.bisbis10.enitites;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

public class ResponseRestaurantNoDish {
    public ResponseRestaurantNoDish(int id, String name, float rating, boolean isKosher, Set<String> cuisines) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public ResponseRestaurantNoDish(Restaurant restaurant){
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.rating = restaurant.getRating();
        this.isKosher = restaurant.isKosher();
        this.cuisines =restaurant.getCuisines();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isKosher() {
        return isKosher;
    }

    public void setKosher(boolean kosher) {
        isKosher = kosher;
    }

    public Set<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

    private int id;
    private String name;
    private float rating;
    private boolean isKosher;
    private Set<String> cuisines;

}
