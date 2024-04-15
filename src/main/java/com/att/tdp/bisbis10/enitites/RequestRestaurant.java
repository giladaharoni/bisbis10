package com.att.tdp.bisbis10.enitites;

import java.util.Set;

public class RequestRestaurant {
    public RequestRestaurant(String name, boolean isKosher, Set<String> cuisines) {
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    private String name;
    private boolean isKosher;
    private Set<String> cuisines;
}
