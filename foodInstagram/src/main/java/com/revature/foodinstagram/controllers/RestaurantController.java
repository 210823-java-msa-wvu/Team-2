package com.revature.foodinstagram.controllers;

import com.revature.foodinstagram.beans.Post;
import com.revature.foodinstagram.beans.Restaurant;
import com.revature.foodinstagram.repositories.PostRepo;
import com.revature.foodinstagram.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/restaurants")
public class RestaurantController {

    private RestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantController(RestaurantRepo restaurantRepo){
        this.restaurantRepo = restaurantRepo;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurant(){
        return restaurantRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public Restaurant getById(@PathVariable("id") int id){
        return restaurantRepo.getById(id);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @PutMapping(path="/{id}")
    public void updateRestaurant(@PathVariable("id") int id, @RequestBody Restaurant restaurant) {
        if (id == restaurant.getRest_id()) {
            restaurantRepo.save(restaurant);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteRestaurant(@PathVariable("id") int id) {
        restaurantRepo.delete(restaurantRepo.getById(id));
    }
}
