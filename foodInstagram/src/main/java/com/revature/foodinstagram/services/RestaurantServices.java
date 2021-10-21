package com.revature.foodinstagram.services;

import com.revature.foodinstagram.beans.Restaurant;
import com.revature.foodinstagram.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServices {

    private final RestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantServices(RestaurantRepo restaurantRepo){
        this.restaurantRepo = restaurantRepo;
    }

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepo.findAll();
    }

    public Restaurant addRestaurant(Restaurant restaurant){
        if(restaurant !=null){
          Restaurant r = restaurantRepo.save(restaurant);
        }
            return null;
    }

    public Restaurant getRestaurantById(Integer id){
        Optional<Restaurant> r = restaurantRepo.findById(id);
        return r.orElse(null);
    }

    public void updateRestaurant(Restaurant restaurant){
        if(restaurant != null){
            restaurantRepo.save(restaurant);
        }
    }

    public void deleteRestaurant(Integer id){
        restaurantRepo.delete(restaurantRepo.getById(id));
    }
    
}
