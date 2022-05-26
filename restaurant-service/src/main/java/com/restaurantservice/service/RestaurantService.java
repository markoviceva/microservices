package com.restaurantservice.service;

import com.restaurantservice.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> findAll();
    Restaurant findById(Integer id);
    List<Restaurant> findByName(String name);
    List<Restaurant> findAllByCity (String city);
    Restaurant save (Restaurant restaurant);
    void delete (Integer id);
}
