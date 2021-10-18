package com.revature.repository;

import com.revature.beans.Restaurants;

import java.util.List;

public interface RestaurantRepo extends CrudRepo<Restaurants>{

    Restaurants add(Restaurants restaurants);

    Restaurants getById(Integer id);

    List<Restaurants> getAll();

    void update(Restaurants restaurants);

    void delete(int id);
    
}
