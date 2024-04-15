package com.att.tdp.bisbis10.enitites;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Restaurant {
    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Set<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

    public boolean isKosher() {
        return isKosher;
    }

    public void setKosher(boolean kosher) {
        isKosher = kosher;
    }

    public float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Restaurant(){
        super();
    }

    public Restaurant(int id, String name, float rating, boolean isKosher, Set<String> cuisines, Set<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
        this.dishes = dishes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private float rating;
    private boolean isKosher;
    private Set<String> cuisines;
    @ManyToMany
    private Set<Dish> dishes;

    public Restaurant(String name, float rating, boolean isKosher, Set<String> cuisines) {
        this.name = name;
        this.rating = rating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Restaurant(RequestRestaurant restaurant){
        this.name = restaurant.getName();
        this.isKosher = restaurant.isKosher();
        this.cuisines = restaurant.getCuisines();
    }


    public void setRating(float rating) {
        this.rating = rating;
    }
}
