package com.restaurantservice.repository;

import com.restaurantservice.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    List<Restaurant> findByNameIgnoreCase (String name);
    List<Restaurant> findAllByCityIgnoreCase (String city);
}
