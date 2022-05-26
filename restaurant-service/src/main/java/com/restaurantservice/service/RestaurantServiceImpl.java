package com.restaurantservice.service;

import com.restaurantservice.model.Restaurant;
import com.restaurantservice.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (!restaurant.isPresent()) {
            throw new RuntimeException("Restaurant doesn't exist");
        }
        return restaurant.get();
    }

    @Override
    public List<Restaurant> findByName(String name) {
        return restaurantRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Restaurant> findAllByCity(String city) {
        return restaurantRepository.findAllByCityIgnoreCase(city);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(restaurant.getId());
        if (existingRestaurant.isPresent()) {
            throw new RuntimeException("Restaurant already exists!");
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Integer id) {
        restaurantRepository.deleteById(id);
    }
}
