package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.enitites.RequestRating;
import com.att.tdp.bisbis10.enitites.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RestaurantRepo repo;
    @PostMapping("")
    ResponseEntity<String> post(@RequestBody RequestRating rating){
        Optional<Restaurant> restaurant = repo.findById(rating.getRestaurantId());
        if (restaurant.isPresent()){
            Restaurant restaurant1 = restaurant.get();
            restaurant1.setRating(rating.getRating());
            repo.save(restaurant1);
            return ResponseEntity.ok().body("OK");
        }
        return ResponseEntity.badRequest().body("Not Found");

    }
}
