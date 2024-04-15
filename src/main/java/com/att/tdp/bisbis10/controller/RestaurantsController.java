package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.enitites.*;
import com.att.tdp.bisbis10.repositories.DishRepo;
import com.att.tdp.bisbis10.repositories.RestaurantRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/restaurants")
public class RestaurantsController {
    @Autowired
    private RestaurantRepo repo;
    @Autowired
    private DishRepo dishRepo;

    @GetMapping("")
    ResponseEntity<List<ResponseRestaurantNoDish>> getAll(){
        List<Restaurant> restaurants = repo.findAll();
        List<ResponseRestaurantNoDish> restaurantNoDishes =
                restaurants.stream().map(ResponseRestaurantNoDish::new).toList();
        return ResponseEntity.ok(restaurantNoDishes);
    }

    @GetMapping("cuisine={cuisine}")
    ResponseEntity<List<ResponseRestaurantNoDish>> byCuisine(@PathVariable String cuisine){
        List<Restaurant> restaurants = repo.findAll();
        restaurants =
                restaurants.stream().filter(restaurant -> {return restaurant.getCuisines().contains(cuisine);}).toList();
        return ResponseEntity.ok(restaurants.stream().map(ResponseRestaurantNoDish::new).toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<Restaurant> oneRest(@PathVariable int id){
        if (repo.findById(id).isPresent()){
           return ResponseEntity.ok(repo.findById(id).get());
        }
        return ResponseEntity.badRequest().body(null);
    }


    //{"name": "Taizu","isKosher": false,"cuisines": ["Asian","Mexican","Indian"]}
    @PostMapping("")
    ResponseEntity<String> addRest(@RequestBody RequestRestaurant res){
        Restaurant restaurant = new Restaurant(res);
        repo.save(restaurant);
        return ResponseEntity.status(201).body("CREATED");
    }

    @PutMapping("{id}")
    ResponseEntity<String> updateRest(@PathVariable int id,@RequestBody RequestCuisines cuisines){
        if (repo.findById(id).isPresent()){
            Restaurant restaurant = repo.findById(id).get();
            restaurant.setCuisines(cuisines.getCuisinesSet());
            repo.save(restaurant);
            return ResponseEntity.ok("OK");
        }
        return ResponseEntity.badRequest().body("Bad request");
    }

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteRest(@PathVariable int id){
        repo.deleteById(id);
        return ResponseEntity.status(204).body("No Content");
    }

    @PostMapping("{id}/dishes")
    ResponseEntity<String> addDish(@PathVariable int id, @RequestBody RequestDish dish){
        if (repo.findById(id).isPresent()){
            Restaurant restaurant = repo.findById(id).get();
            Dish newDish = new Dish(dish);
            dishRepo.save(newDish);
            restaurant.getDishes().add(newDish);
            repo.save(restaurant);
        }
        return ResponseEntity.status(201).body("CREATED");
    }

    @PutMapping("{id}/dishes/{dishId}")
    ResponseEntity<String> updateDish(@PathVariable int id, @PathVariable int dishId, @RequestBody UpdateDish updateDish ){
        if (repo.findById(id).isPresent()){
            Restaurant restaurant = repo.findById(id).get();
            Dish finded = restaurant.getDishes().stream().filter(dish -> {
                return dish.getId()==dishId;
            }).findFirst().get();
            finded.setDescription(updateDish.getDescription());
            finded.setPrice(updateDish.getPrice());
            dishRepo.save(finded);
        }
        return ResponseEntity.status(200).body("OK");
    }

    @DeleteMapping("/{id}/dishes/{dishId}")
    ResponseEntity<String> deleteRestDish(@PathVariable int id, @PathVariable int dishId){
        Restaurant restaurant = repo.findById(id).get();
        restaurant.getDishes().remove(dishRepo.findById(dishId).get());
        repo.save(restaurant);
        return ResponseEntity.status(204).body("No Content");
    }

    @GetMapping("{id}/dishes")
    ResponseEntity<Set<Dish>> getDishes(@PathVariable int id){
        if (repo.findById(id).isPresent()){
            Restaurant restaurant = repo.findById(id).get();
            return ResponseEntity.ok(restaurant.getDishes());

        }
        return ResponseEntity.badRequest().body(null);
    }


}
