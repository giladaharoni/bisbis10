package com.att.tdp.bisbis10.enitites;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequestCuisines {
    private List<String> cuisines;

    public RequestCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }
    public RequestCuisines(){
        super();
    }

    public Set<String> getCuisinesSet() {
        return new HashSet<>(cuisines);
    }
    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }
}
